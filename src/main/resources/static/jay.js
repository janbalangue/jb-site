document.addEventListener("DOMContentLoaded", () => {
    const btn = document.getElementById("scrollTopBtn");
    if (!btn) return;

    btn.addEventListener("click", (event) => {
        // The link's #top href is the no-JS fallback; scrolling here keeps the hash out of the URL.
        event.preventDefault();
        const reduceMotion = window.matchMedia("(prefers-reduced-motion: reduce)").matches;
        window.scrollTo({
            top: 0,
            behavior: reduceMotion ? "auto" : "smooth"
        });
    });
});
