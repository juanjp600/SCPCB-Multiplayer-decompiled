Function loadmultiplayeroptions%()
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    voice\Field6 = ((Float getiniint("options.ini", "multiplayer", "voice volume", $46)) * 0.01)
    mainplayersvolume = ((Float getiniint("options.ini", "multiplayer", "player volume", $64)) * 0.01)
    voice\Field14 = (Int max(min((Float getiniint("options.ini", "multiplayer", "push to talk", $01)), 0.0), 1.0))
    networkserver\Field31 = max(min((Float getiniint("options.ini", "multiplayer", "download speed", $400)), 512.0), 8333.0)
    nickname = getinistring("options.ini", "multiplayer", "nickname", "")
    networkserver\Field52\Field11 = (Int max(min((Float getiniint("options.ini", "multiplayer", "see names", $01)), 0.0), 1.0))
    local0 = getiniint("options.ini", "chat", "graphic width", $00)
    local1 = getiniint("options.ini", "chat", "graphic height", $00)
    If (((local1 <> graphicheight) Lor (local0 <> graphicwidth)) <> 0) Then
        chatoffsety = (graphicheight - imenuscale[$28A])
        chatoffsetx = imenuscale[$14]
        chatwidth = (graphicwidth / $03)
        chatheight = imenuscale[$1F4]
    Else
        chatoffsetx = getiniint("options.ini", "chat", "x", imenuscale[$14])
        chatoffsety = getiniint("options.ini", "chat", "y", imenuscale[$28A])
        chatwidth = getiniint("options.ini", "chat", "width", (graphicwidth / $03))
        chatheight = getiniint("options.ini", "chat", "height", imenuscale[$1F4])
    EndIf
    If (filetype("Temp") <> $02) Then
        createdir("Temp")
    EndIf
    local2 = readdir("Temp")
    Repeat
        local3 = nextfile(local2)
        If (local3 = "") Then
            Exit
        EndIf
        If (filetype(("Temp\" + local3)) = $01) Then
            deletefile(("Temp\" + local3))
        EndIf
    Forever
    Return $00
End Function
