Function zipapi_gotofirstfile%(arg0%)
    If (arg0 < $01) Then
        Return $FFFFFFCD
    EndIf
    Return zlibwapi_unzgotofirstfile(arg0)
    Return $00
End Function
