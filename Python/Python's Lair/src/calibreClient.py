import socket,sys

def Main():
    ClientRun()


def ClientRun():
    host = socket.gethostname()
    port = 5520
    s = socket.socket()
    s.connect((host, port))
    # A Change of Air
    file_name = input("Enter file name or q to exit: -> ")

    s.send(bytes(file_name, 'UTF-8'))  # bytes(message, 'UTF-8')

    f = open('tester', 'w')
    print('file opened')
    while True:

        data = s.recv(1024).decode('UTF-8')
        print('received data...\n\n')
        if not data:
            break
        print(data)
        # write data to a file
        f.write(data)

    f.close()
    print('Successfully get the file')
    s.close()
    print('connection closed')








if __name__=='__main__':
    Main()