use std::ops::Range;

use plotters::prelude::*;

const PIXEL_WIDTH: u32 = 100;
const PIXEL_HEIGHT: u32 = 100;
const CHART_MAX: f32 = 1.5;
const CHART_MIN: f32 = -1.5;
const MAX_CHECKS: Range<u32> = 0..100;
// Keep the max checks at or bellow 100 until a different color space is
// used or I write an equation to determine what color it will be within
// my colorspace

fn main() {
    let root = BitMapBackend::new("2.5.png", (PIXEL_WIDTH, PIXEL_HEIGHT))
        .into_drawing_area();

    let mut chart = ChartBuilder::on(&root)
        .build_ranged(CHART_MIN..CHART_MAX, CHART_MIN..CHART_MAX)
        .unwrap();


    let plotting_area = chart.plotting_area();

    let range = plotting_area.get_pixel_range();

    for x in range.0.clone() {
        let mandelbrot_x = map_range_mandelbrot(&x, &range.0, &plotting_area.get_x_range());
        for y in range.1.clone() {
            let mandelbrot_y = map_range_mandelbrot(&y, &range.1, &plotting_area.get_y_range());

            let iter = calc_pixel_mandelbrot(&mandelbrot_x, &mandelbrot_y);

            if iter != 100 {
                plotting_area.draw_pixel((mandelbrot_x, mandelbrot_y), &HSLColor(iter as f64 / 100.0, iter as f64 / 100.0, iter as f64 / 100.0)).unwrap();
            } else {
                plotting_area.draw_pixel((mandelbrot_x, mandelbrot_y), &BLACK).unwrap();
            }
        }
    }
}

fn calc_pixel_mandelbrot(x: &f32, y: &f32) -> u32 {
    let mut new_x = x.clone();
    let mut new_y = y.clone();

    for iter in MAX_CHECKS {
        let real_comp = new_x * new_x - new_y * new_y;
        let imag_comp = 2.0 * new_x * new_y;
        new_x = real_comp + x;
        new_y = imag_comp + y;

        if new_x + new_y > 16.0 {
            return iter;
        }
    }

    MAX_CHECKS.end
}

fn map_range_mandelbrot(pixel_val: &i32, pixel_range: &Range<i32>, mandelbrot_range: &Range<f32>) -> f32 {
    let pixel_total = pixel_range.start + pixel_range.end;
    let mandelbrot_total = mandelbrot_range.start.abs() + mandelbrot_range.end.abs();

    let maths = CHART_MIN + (mandelbrot_total * pixel_val.clone() as f32 / pixel_total as f32);

    maths
}
