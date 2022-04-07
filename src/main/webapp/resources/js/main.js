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

const updatePres = (id, obj) => {
    event.preventDefault();
    fetch("/PrivateClinicsManagement/api/update-pres", {
        method: 'put',
        body: JSON.stringify({
            "id": id,
            "quantity": obj.value,
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
        let amount = document.getElementsByClassName('presAmount');
        for (let i = 0; i < amount.length; i++) {
            amount[i].innerText = data.totalAmount;
        }
    })
}

const deletePres = (id) => {
    if (confirm("Are you sure to delete this item?") == true) {
        event.preventDefault();
        fetch(`/PrivateClinicsManagement/api/delete-pres/${id}`, {
            method: 'delete',
        }).then(res => res.json()).then(data => {
            console.info(data)
            let prescriptions = document.getElementsByClassName('presCounter');
            for (let i = 0; i < prescriptions.length; i++) {
                prescriptions[i].innerText = data.totalQuantity;
            }
            let amount = document.getElementsByClassName('presAmount');
            for (let i = 0; i < amount.length; i++) {
                amount[i].innerText = data.totalAmount;
            }
            location.reload();
        })
    }
}

const pay = () => {
    if (confirm("Are you sure to process this precription")) {
        fetch(`/PrivateClinicsManagement/api/pay`, {
            method: 'post'
        }).then(res => {
            if (res.status === 201) {
                location.reload();
            } else {
                alert("Something wrong");
            }
        })
    }
}