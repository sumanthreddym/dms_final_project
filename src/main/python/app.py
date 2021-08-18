import os
import joblib
from flask import Flask, jsonify, request
from flask_restful import Api, Resource

app = Flask(__name__)
api = Api(app)


class PredictKidneyDisease(Resource):
    @staticmethod
    def post():
        data = request.get_json()

        model = joblib.load('chronic_disease_kidney.model')
        prediction = model.predict([[data['age'], data['bloodPressure'], data['specificGravity'], data['albumin'], data['sugar'],data['redBloodCells'], data['pusCell'], data['pusCellClumps'], data['bacteria'],data['bloodGlucoseRandom'], data['bloodUrea'], data['serumCreatinine'], data['sodium'],data['potassium'], data['haemoglobin'], data['packedCellVolume'],data['whiteBloodCellCount'], data['redBloodCellCount'], data['hypertension'],data['diabetesMellitus'], data['coronaryArteryDisease'], data['appetite'],data['pedalEdema'], data['anemia']]])
        return jsonify(str(prediction[0]))


api.add_resource(PredictKidneyDisease, '/predict_kidney_disease')

if __name__ == '__main__':
    app.run(debug=True)