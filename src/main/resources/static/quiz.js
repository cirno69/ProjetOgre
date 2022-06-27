const jsonQuiz = (function() {
    var json = null;
    $.ajax({
    'async': false,
    'global': false,
    'url': "/quiz.json",
    'dataType': "json",
    'success': function (data) {
        json = data;
        }
    });
    return json;
})();

var divQuiz = document.getElementById('quiz');

for (var i=0; i<jsonQuiz.questions; i++) {
    var tmpAnswers = '';
    for (var j=0; j<Object.keys(jsonQuiz[i].answers).length; j++) {
        tmpAnswers += '<div><input type="radio" id="question'+i+'answer'+j+'" name="question'+i+'" value="'+j+'"><label>' + jsonQuiz[i].answers[j] + '</label></div>';
    }
    divQuiz.innerHTML += '<fieldset question="'+i+'"><legend>' + jsonQuiz[i].question + '</legend>' + tmpAnswers + '</fieldset><br><br>';
}

function checkQuiz() {
    var questions = divQuiz.getElementsByTagName('fieldset');
    var score = 0;

    for (var i=0; i<questions.length; i++) {
        var questionID = questions[i].getAttribute('question');
        var inputs = questions[i].getElementsByTagName('div');
        var isChecked = false;
        for (var j=0; j<inputs.length; j++) {
            var input = inputs[j].getElementsByTagName('input')[0];
            if (input.checked) {
                isChecked = true;
                if (jsonQuiz[questionID].answer == input.value) {
                    score++;
                } else {
                    input.parentElement.style.color = 'red';
                    input.parentElement.lastElementChild.style.fontWeight = 'bold';
                    input.parentElement.lastElementChild.style.textDecoration = 'line-through';
                }
            }
            if(jsonQuiz[questionID].answer == input.value) {
                input.parentElement.style.color = 'green';
                input.parentElement.lastElementChild.style.fontWeight = 'bold';
                input.parentElement.lastElementChild.textDecoration = 'underline';
            }
        }
        if (!isChecked) {
            inputs[0].getElementsByTagName('input')[0].parentElement.parentElement.style.color = 'red';
        }
    }
    if (score == 10) {
        document.getElementById('scoreElement').innerHTML = 'Incroyable ! Les énérgies n\'ont plus de secret pour vous.<br>Vous avez un score de ' + score + '/' + jsonQuiz.questions +'.';
    } else if (score > 7) {
        document.getElementById('scoreElement').innerHTML = 'Félicitation ! Les énérgies n\'ont quasiment plus de secret pour vous, un dernier petit effort et vous saurez tout.<br>Vous avez un score de ' + score + '/' + jsonQuiz.questions +'.';
    } else if (score > 5) {
        document.getElementById('scoreElement').innerHTML = 'Bravo ! Néanmoins vous pouvez vous améliorer. Participez à un atelier OGRE pour en apprendre davantage sur les énérgie.<br>Vous avez un score de ' + score + '/' + jsonQuiz.questions +'.';
    } else if (score > 3) {
        document.getElementById('scoreElement').innerHTML = 'Courage ! Vous allez réussir à mieux connaitre les énérgies. Participez à un atelier OGRE pour en apprendre davantage sur les énérgie.<br>Vous avez un score de ' + score + '/' + jsonQuiz.questions +'.';
    } else {
        document.getElementById('scoreElement').innerHTML = 'Accrochez-vous ! Vous ne pouvez que progresser ! Participez à un atelier OGRE pour en apprendre davantage sur les énérgie.<br>Vous avez un score de ' + score + '/' + jsonQuiz.questions +'.';
    }
}
