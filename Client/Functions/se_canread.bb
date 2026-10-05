Function se_canread%(arg0%, arg1%)
    If (((arg1 < $00) Or (filepos(arg0) > (se_loadfilesize - arg1))) <> 0) Then
        se_loadinvalid = $01
        Return $00
    EndIf
    Return $01
    Return $00
End Function
