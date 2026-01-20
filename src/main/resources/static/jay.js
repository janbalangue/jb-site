// Optional small enhancements.
// - Set an "active" style on the clicked tab
// - Smooth scroll for anchor links


document.addEventListener('click', (e) => {
    const tab = e.target.closest('button.tab');
    if (tab) {
        document.querySelectorAll('button.tab').forEach(b => b.dataset.active = 'false');
        tab.dataset.active = 'true';
    }
});


document.querySelectorAll('a[href^="#"]').forEach(a => {
    a.addEventListener('click', (e) => {
        const id = a.getAttribute('href');
        const el = document.querySelector(id);
        if (el) {
            e.preventDefault();
            el.scrollIntoView({behavior: 'smooth', block: 'start'});
            history.replaceState(null, '', id);
        }
    });
});

const scrollTopBtn = document.getElementById('scrollTopBtn');

scrollTopBtn?.addEventListener('click', () => {
    document.getElementById('top')?.scrollIntoView({
        behavior: 'smooth',
        block: 'start'
    });
});
