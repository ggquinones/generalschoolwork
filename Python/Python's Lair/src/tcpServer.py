import socket

def Main():
    host = '127.0.0.1'
    port = 5001

    s = socket.socket()
    s.bind((host,port))
    s.listen(1)

    c, addr = s.accept()
    print("Connection from: " + str(addr))
    while True:
        data = c.recv(1024).decode('UTF-8')
        if not data:
            break

        print("From connected user: "+ str(data))
        data = str(data.lower())
        if data=='square':
            data = 'XXX\nX X\nXXX'
        elif data=='rectangle':
            data='XXXX\nX  X\nXXXX'
        elif data=='diamond':
            data='  X\n X X\nX   X\n X X\n  X'
        elif data=='rhombus':
            data='XXXX\n X  X\n  X  X\n   XXXX'

        print("sending: \n" + str(data))
        c.send(bytes(data, 'UTF-8'))
    c.close()

if __name__ == '__main__':
    Main()



