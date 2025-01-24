Function execfile_strict%(arg0$)
    If (filetype((lang\Field1 + arg0)) = $01) Then
        arg0 = (lang\Field1 + arg0)
    EndIf
    execfile(arg0)
    Return $00
End Function
