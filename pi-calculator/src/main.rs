use std::ops::Range;

const ACCURACY: Range<u128> = 1..500000;

fn main() {    
    let mut init_divisor: f64 = 3.0;
    let mut pi: f64 = 1.0;

    for iter in ACCURACY {
        if iter % 2 == 1 {
            pi = pi - (1.0 / init_divisor);
        } else {
            pi = pi + (1.0 / init_divisor);
        }
        init_divisor = init_divisor + 2.0;
    }

    pi = 4.0 * pi;
    println!("{}", pi.to_string());
}

