const puppeteer = require('puppeteer');

(async () => {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto('https://www.dsbmobile.de', {waitUntil: 'networkidle2'});
    var txtUser = await page.$('#txtUser');
    await txtUser.type("USER");
    var txtPass = await page.$('#txtPass');
    await txtPass.type("PASS");
    var loginButton = await page.$('.login');
    await loginButton.click();
    await page.waitForNavigation({waitUntil: 'networkidle0'});
    await page.screenshot({'path': 'screenshot.png'});
    var uuidElem = await page.$('.timetable-element');
    console.log(await page.evaluate((el) => {
        return el.getAttribute("data-uuid");
    }, uuidElem));
    await uuidElem.screenshot({'path': 'elem.png'});
    await browser.close();

})();
