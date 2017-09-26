import socket


def Main():
    ServerRun()

def ServerRun():
    host = socket.gethostname()
    port = 5520
    s = socket.socket()
    s.bind((host, port))
    s.listen(5)
    conn, addr = s.accept()

    #print("Connection from: " + str(addr))
    flag = '?'
    while flag is not '*':
        while True:
            data = conn.recv(1024).decode('UTF-8')
            if not data:
                break

            # print("From connected user: " + str(data))
            f = open(data, 'r')
            part = f.read(1024)
            while (part):
                conn.send(bytes(part, 'UTF-8'))
                part = f.read(1024)
            f.close()

            break
        conn.close()
        flag = conn.recv(1024).decode('UTF-8')

if __name__ == '__main__':
    Main()