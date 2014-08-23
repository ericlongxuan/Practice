
class T(object):
	def __init__(self):
		self.a = 1
		self.dictb = {'one': 1, 'two': 2, 'three': 3}

def get_app():
	app = T()
	return app


def change(app):
	app.a = 2
	app.dictb = {'ww':12}
	app = 1




