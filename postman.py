

# MANUALLY PUT  / DELETE

import requests






# # DELETE
# for x in range(51 , 60 , 1 ):
#     url = 'http://127.0.0.1:8080/courses/'+str(x)
#     r = requests.delete(url)
#     pprint.pprint(  r.json() )


# url = 'http://127.0.0.1:8080/courses/45'
# r = requests.delete(url)
# pprint.pprint(  r.json() )









# # POST
# myobj = {
#     "title" : "test",
#     "instructor" : "life",
# }

# url = 'http://127.0.0.1:8080/courses'
# for x in range(0,3,1):
#     myobj['title'] = '===' * x
#     myobj['instructor'] = myobj['instructor']
#     r = requests.post(url, json = myobj)










# PUT
# myobj = {
#     "courseid" : "21",
#     "title" : "ooooooooooooooooo",
#     "instructor" : "was heoooooooooooooooooore?",
# }
# url = 'http://127.0.0.1:8080/courses'
# r = requests.put(url=url, json = myobj)
# print(r.text)







# GET
# url = 'http://127.0.0.1:8080/courses/'
# r = requests.get(url)
# pprint.pprint(  r.json() )








# ADD ADMIN
# url = 'http://localhost:8080/admin'
# myobj = {
#     "email" : "fareed320@gmail.com",
#     "pass_key":"yoooo plz work"
# }
# r = requests.post(url, json=myobj)
# print(  r.text )






# SEND EMAIL
# url = 'http://localhost:8080/sendmail?to=laflametoast@gmail.com&subject=nice%20work&body=im%20very%20happy%20with%20my%20work'
# r = requests.get(url)
# pprint.pprint(  r.text )