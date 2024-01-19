Function updateinput%()
    Local local0%
    If (0.0 >= input_resettime) Then
        keyhite = keyhit(key_using)
        keydowne = keydown($12)
        doubleclick = $00
        mousehit1 = (mousehit($01) <> $00)
        If (mousehit1 <> 0) Then
            If ((millisecs2() - lastmousehit1) < $12C) Then
                doubleclick = $01
            EndIf
            lastmousehit1 = millisecs2()
        EndIf
        local0 = mousedown1
        mousedown1 = (mousedown($01) <> $00)
        If (((local0 = $01) And (mousedown1 = $00)) <> 0) Then
            mouseup1 = $01
        Else
            mouseup1 = $00
        EndIf
        mousehit2 = (mousehit($02) <> $00)
        If (((mousedown1 = $00) And (mousehit1 = $00)) <> 0) Then
            grabbedentity = $00
        EndIf
    Else
        input_resettime = max((input_resettime - fpsfactor), 0.0)
    EndIf
    keybuffer(key_left) = keydown(key_left)
    keybuffer(key_right) = keydown(key_right)
    keybuffer(key_up) = keydown(key_up)
    keybuffer(key_down) = keydown(key_down)
    keybuffer(key_sprint) = keydown(key_sprint)
    Return $00
End Function
