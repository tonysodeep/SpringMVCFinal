/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const addToPres = (id, name, price) => {
    event.preventDefault();
    fetch("/PrivateClinicsManagement/api/add-pres", {
        method: 'post',
        body: JSON.stringify({
            "id": id,
            "name": name,
            "price": price,
            "quantity": 1,
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json()).then(data => {
        console.info(data)
        let prescriptions = document.getElementsByClassName('presCounter');
        console.info('length', prescriptions.length);
        for (let i = 0; i < prescriptions.length; i++) {
            prescriptions[i].innerText = data.totalQuantity;
        }
    })
}
