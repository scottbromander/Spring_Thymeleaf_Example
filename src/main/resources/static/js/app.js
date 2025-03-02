function fetchData() {
    fetch('/api/data')
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById('data-list');
            list.innerHTML = ''; // Clear previous entries
            data.forEach(item => {
                const li = document.createElement('li');
                li.textContent = `${item.id}: ${item.name}`;
                list.appendChild(li);
            });
        })
        .catch(error => console.error('Error fetching data:', error));
}
