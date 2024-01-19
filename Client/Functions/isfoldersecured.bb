Function isfoldersecured%(arg0$)
    If ((((instr(arg0, "..", $01) Or instr(arg0, "...", $01)) Or instr(arg0, "%", $01)) Or instr(arg0, "&", $01)) <> 0) Then
        Return $00
    EndIf
    Select lower(right(arg0, $04))
        Case ".exe",".dll",".vbs",".bat",".cmd"
            Return $00
    End Select
    Return $01
    Return $00
End Function
