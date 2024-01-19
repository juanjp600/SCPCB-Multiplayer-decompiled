Function ws_redirectfile%(arg0$, arg1$)
    If (isfoldersecured(arg0) <> 0) Then
        If (filetype(arg1) <> $00) Then
            If (ws_writebackup(arg0) <> $00) Then
                deletefile(arg0)
                copyfile(arg1, arg0)
                If (arg0 = "GFX\blinkmeter.jpg") Then
                    freeimage(blinkmeterimg)
                    blinkmeterimg = loadimage_strict("GFX\blinkmeter.jpg")
                EndIf
                Return $01
            EndIf
        EndIf
    EndIf
    Return $00
    Return $00
End Function
