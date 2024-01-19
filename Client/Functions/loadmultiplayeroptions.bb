Function loadmultiplayeroptions%(arg0%)
    Local local0%
    Local local1$
    Local local2%
    Local local3$
    Local local4%
    Local local5%
    Local local6.servers
    Local local7%
    Local local8%
    If (filetype("Temp") <> $02) Then
        createdir("Temp")
    EndIf
    local0 = readdir("Temp")
    Repeat
        local1 = nextfile(local0)
        If (local1 = "") Then
            Exit
        EndIf
        If (filetype(("Temp\" + local1)) = $01) Then
            deletefile(("Temp\" + local1))
        EndIf
    Forever
    If (filesize("Data\multiplayer.ini") = $00) Then
        createfile("Data\multiplayer.ini")
        networkserver\Field25 = $01
        voice\Field6 = 0.7
        mainplayersvolume = 1.0
        networkserver\Field41 = 1024.0
        savemultiplayeroptions()
        key_chat = $40
        key_voice = $2F
        Return $00
    EndIf
    local2 = readfile("Data\multiplayer.ini")
    If (0.67 > readfloat(local2)) Then
        closefile(local2)
        deletefile("Data\multiplayer.ini")
        createfile("Data\multiplayer.ini")
        networkserver\Field25 = $01
        voice\Field6 = 0.7
        networkserver\Field41 = 1024.0
        mainplayersvolume = 1.0
        savemultiplayeroptions()
        Return $00
    EndIf
    nickname = readline(local2)
    readline(local2)
    networkserver\Field25 = readint(local2)
    networkserver\Field24 = readint(local2)
    Repeat
        If (readint(local2) = $00) Then
            Exit
        EndIf
        readint(local2)
        readint(local2)
        readint(local2)
    Forever
    voice\Field6 = ((Float readbyte(local2)) / 100.0)
    mainplayersvolume = ((Float readbyte(local2)) / 100.0)
    networkserver\Field40 = readbyte(local2)
    networkserver\Field41 = (Float readshort(local2))
    voice\Field14 = readbyte(local2)
    Repeat
        If (readint(local2) = $00) Then
            Exit
        EndIf
        local3 = dottedip(readint(local2))
        local4 = readint(local2)
        local5 = readint(local2)
        If (local3 = "0.0.0.0") Then
            local3 = "localhost"
        EndIf
        multiplayer_list_addserver(local3, local4, local5, $00, $00)
    Forever
    For local6 = Each servers
        If ((((local6\Field0 = $04) Or (local6\Field0 = $01)) Or (local6\Field0 = $05)) <> 0) Then
            Delete local6
        EndIf
    Next
    If (eof(local2) <> 0) Then
        chatoffsety = ((Float graphicheight) - (650.0 * menuscale))
        chatoffsetx = (20.0 * menuscale)
        chatwidth = ((Float graphicwidth) / 3.2)
        chatheight = (450.0 * menuscale)
    Else
        local7 = (Int readfloat(local2))
        local8 = (Int readfloat(local2))
        chatoffsetx = readfloat(local2)
        chatoffsety = readfloat(local2)
        chatwidth = readfloat(local2)
        chatheight = readfloat(local2)
        chattypes = readbyte(local2)
        If (((local7 <> graphicwidth) Or (local8 <> graphicheight)) <> 0) Then
            chatoffsety = ((Float graphicheight) - (500.0 * menuscale))
            chatoffsetx = (20.0 * menuscale)
            chatwidth = ((Float graphicwidth) / 3.2)
            chatheight = (300.0 * menuscale)
        EndIf
    EndIf
    closefile(local2)
    Return $00
End Function
