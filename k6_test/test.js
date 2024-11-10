import http from 'k6/http';
import { check, sleep } from 'k6';
import { randomIntBetween } from 'https://jslib.k6.io/k6-utils/1.2.0/index.js';

//Constant VUs

// export const options = {
//     scenarios: {
//         arbitrary_scenario_name: {
//             executor: 'constant-vus',
//             vus: 20,
//             duration: '60s',
//         },
//     },
// };

//Ramping VUs

// export const options = {
//     scenarios: {
//         arbitrary_scenario_name: {
//             executor: 'ramping-vus',
//             stages: [
//                 {duration: '60s', target: 20},
//                 {duration: '60s', target: 20},
//                 {duration: '60s', target: 0},
//             ],
//         },
//     },
// };

//Constant Arrival Rate
export const options = {
    discardResponseBodies: true,
    scenarios: {
        contacts: {
            executor: 'constant-arrival-rate',
            duration: '30s',
            rate: 30,
            timeUnit: '1s',

            // Pre-allocate 2 VUs before starting the test
            preAllocatedVUs: 2,

            // Spin up a maximum of 50 VUs to sustain the defined
            // constant arrival rate.
            maxVUs: 50,
        },
    },
};

export default function () {
    const id = randomIntBetween(1, 3)
    const url = `http://localhost:8080/products/${id}`
    const res = http.get(url);
    check(res, { 'status was 200': (r) => r.status == 200 });

    sleep(Math.random() * 3 + 1);
}