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

const drawPieChart = (ctx, labels, data) => {
    const myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: labels, //['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
            datasets: [{
                    label: '# of Votes',
                    data: data, //[12, 19, 3, 5, 2, 3],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

const drawBarChart = (ctx, labels, data) => {
        const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels, //['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
            datasets: [{
                    label: '# of Votes',
                    data: data, //[12, 19, 3, 5, 2, 3],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}