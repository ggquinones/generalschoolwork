import socket

def Main():
    host = '127.0.0.1'
    port = 5001

    s=socket.socket()
    s.connect((host,port))

    message = input("Enter a quadrilateral or q to exit-> ")
    while message != 'q':
        s.send(bytes(message, 'UTF-8'))  #bytes(message, 'UTF-8')
        data = s.recv(1024).decode('UTF-8')
        print('Received from server: \n'+ str(data))
        message = input('Enter a quadrilateral or q to exit-> ')
    s.close()

if __name__=='__main__':
    Main()