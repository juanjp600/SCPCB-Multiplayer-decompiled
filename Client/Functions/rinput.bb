Function rinput$(arg0$)
    Local local0%
    Local local1$
    Local local2%
    If (len(arg0) = $00) Then
        stringpick = $00
    EndIf
    If (keydown($1D) = $00) Then
        local0 = getkey()
        If (local0 = $00) Then
            local1 = getnumpadkey()
            local0 = (Int piece(local1, $02, " "))
            If (local0 <> $00) Then
                keyssavenumpad = (Int piece(local1, $01, " "))
            EndIf
        EndIf
    Else
        getkey()
    EndIf
    local2 = len(arg0)
    If (local0 = $08) Then
        local0 = $00
        If (local2 > $00) Then
            If (stringpick = len(arg0)) Then
                arg0 = ""
                stringpick = $00
                Return arg0
            EndIf
            arg0 = left(arg0, (local2 - $01))
            If (selectedword = (local2 - $01)) Then
                selectedword = (selectedword - $01)
            EndIf
        EndIf
        keysdelete = (millisecs() + $1F4)
    EndIf
    If ((keydown($1D) And keydown($2F)) <> 0) Then
        If (repeatclipboard = $01) Then
            If (millisecs() > keysclipboard) Then
                If (millisecs() > keysclipboard2) Then
                    If (stringpick = len(arg0)) Then
                        arg0 = getclipboardtext()
                        stringpick = $00
                    Else
                        arg0 = (arg0 + getclipboardtext())
                    EndIf
                    keysclipboard2 = (millisecs() + $14)
                    Return arg0
                EndIf
            EndIf
        Else
            If (stringpick = len(arg0)) Then
                arg0 = getclipboardtext()
                stringpick = $00
            Else
                arg0 = (arg0 + getclipboardtext())
            EndIf
            repeatclipboard = $01
            keysclipboard = (millisecs() + $1F4)
            Return arg0
        EndIf
    Else
        repeatclipboard = $00
        keysclipboard = $00
        keysclipboard2 = $00
    EndIf
    If ((keydown($1D) And keydown($2E)) <> 0) Then
        If (((stringpick = len(arg0)) And (len(arg0) > $00)) <> 0) Then
            setclipboardtext(arg0)
        EndIf
    EndIf
    If (keydown($1D) = $00) Then
        If (keyssave <> $00) Then
            If ((keydown(gethitbykey(keyssave)) Or keydown(keyssavenumpad)) <> 0) Then
                If (millisecs() > keysasc) Then
                    arg0 = (arg0 + chr(keyssave))
                    keysasc = (millisecs() + $14)
                    Return arg0
                EndIf
            Else
                keyssavenumpad = $00
                keysasc = $00
                keyssave = $00
            EndIf
        EndIf
    EndIf
    If ((keydown($1D) And keydown($1E)) <> 0) Then
        stringpick = len(arg0)
        Return arg0
    EndIf
    If (keysdelete <> $00) Then
        If (keydown($0E) <> 0) Then
            If (keysdelete < millisecs()) Then
                If (local2 > $00) Then
                    arg0 = left(arg0, (local2 - $01))
                    If (selectedword = (local2 - $01)) Then
                        selectedword = (selectedword - $01)
                    EndIf
                    keysdelete = (millisecs() + $14)
                EndIf
                Return arg0
            EndIf
        Else
            keysdelete = $00
        EndIf
    EndIf
    If (((local0 = $0D) Or (local0 = $00)) <> 0) Then
        Return arg0
    ElseIf ((((((local0 > $00) And (local0 < $07)) Or (local0 > $1A)) And (local0 < $20)) Or (local0 = $09)) <> 0) Then
        Return arg0
    Else
        If (stringpick = len(arg0)) Then
            arg0 = ""
            stringpick = $00
        EndIf
        arg0 = (arg0 + chr(local0))
        keyssave = local0
        keysasc = (millisecs() + $1F4)
        Return arg0
    EndIf
    Return ""
End Function
