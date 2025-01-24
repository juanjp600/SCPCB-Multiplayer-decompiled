Function updateinput$(arg0$, arg1%)
    Local local0%
    Local local1%
    Local local2$
    local0 = getkey()
    local1 = len(arg0)
    If (((cursorpos < $00) And (cursorpos <> $FFFFFFFF)) <> 0) Then
        cursorpos = local1
    EndIf
    cursorpos = (Int max((Float cursorpos), 0.0))
    If (keyhit($D2) <> 0) Then
        insertmode = (insertmode = $00)
    EndIf
    If (keyhit($C7) <> 0) Then
        cursorpos = $00
    EndIf
    If (keyhit($CF) <> 0) Then
        cursorpos = local1
    EndIf
    If (keyhit($D3) <> 0) Then
        arg0 = (left(arg0, cursorpos) + right(arg0, (Int max((Float ((local1 - cursorpos) - $01)), 0.0))))
        cursorpos = (cursorpos + $01)
    EndIf
    If ((keydown($1D) Lor keydown($9D)) <> 0) Then
        If (local0 = $1E) Then
            cursorpos = local1
        EndIf
        If (local0 = $1F) Then
            cursorpos = $00
        EndIf
        If (local0 = $03) Then
            setclipboardcontents(arg0)
        EndIf
        If (local0 = $16) Then
            local2 = getclipboardcontents()
            If (local2 <> "") Then
                arg0 = ((left(arg0, cursorpos) + local2) + right(arg0, (Int max((Float (local1 - cursorpos)), 0.0))))
                cursorpos = (cursorpos + len(local2))
                If (((arg1 > $00) And (arg1 < len(arg0))) <> 0) Then
                    arg0 = left(arg0, arg1)
                    cursorpos = arg1
                EndIf
            EndIf
        EndIf
        Return arg0
    EndIf
    If (local0 = $1E) Then
        cursorpos = (Int min((Float (cursorpos + $01)), (Float local1)))
        previnputboxctrl = millisecs()
        Return arg0
    EndIf
    If (local0 = $1F) Then
        cursorpos = (Int max((Float (cursorpos - $01)), 0.0))
        previnputboxctrl = millisecs()
        Return arg0
    EndIf
    If ((keydown($CD) And ((millisecs() - previnputboxctrl) > $1F4)) <> 0) Then
        If ((millisecs() Mod $64) < $19) Then
            cursorpos = (Int min((Float (cursorpos + $01)), (Float local1)))
        EndIf
    ElseIf ((keydown($CB) And ((millisecs() - previnputboxctrl) > $1F4)) <> 0) Then
        If ((millisecs() Mod $64) < $19) Then
            cursorpos = (Int max((Float (cursorpos - $01)), 0.0))
        EndIf
    Else
        If (insertmode <> 0) Then
            If (chrcandisplay(local0) <> 0) Then
                arg0 = (textinput(left(arg0, cursorpos)) + mid(arg0, (cursorpos + $02), $FFFFFFFF))
                cursorpos = (cursorpos + $01)
            ElseIf (local0 = $08) Then
                arg0 = (textinput(left(arg0, cursorpos)) + mid(arg0, (cursorpos + $01), $FFFFFFFF))
            ElseIf (local0 = $04) Then
                arg0 = (left(arg0, cursorpos) + right(arg0, (Int max((Float ((local1 - cursorpos) - $01)), 0.0))))
            EndIf
        Else
            arg0 = (textinput(left(arg0, cursorpos)) + mid(arg0, (cursorpos + $01), $FFFFFFFF))
        EndIf
        cursorpos = ((len(arg0) + cursorpos) - local1)
        If (((arg1 > $00) And (arg1 < len(arg0))) <> 0) Then
            arg0 = left(arg0, arg1)
            cursorpos = (Int min((Float cursorpos), (Float arg1)))
        EndIf
    EndIf
    Return arg0
    Return ""
End Function
