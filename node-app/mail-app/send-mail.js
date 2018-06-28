var nodemailer = require('nodemailer');

var transporter = nodemailer.createTransport({
  service: 'gmail',
  auth: {
    user: 'santoshdangodra@gmail.com',
    pass: 'hzlqwtvynjhlurbe'
  }
});

var mailOptions = {
  from: 'santoshdangodra@gmail.com',
  to: 'kannan@swabhavtechlabs.com',
  subject: 'Sending Email using NodeJS Application',
  html: '<h1>First email sent using NodeJS!</h1>'
  // text: 'text message'
};

transporter.sendMail(mailOptions, function(error, info){
  if (error) {
    console.log(error);
  } else {
    console.log('Email sent: ' + info.response);
  }
}); 