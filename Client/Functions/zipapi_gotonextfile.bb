Function zipapi_gotonextfile%(arg0%)
    If (arg0 < $01) Then
        Return $FFFFFFCD
    EndIf
    Return zlibwapi_unzgotonextfile(arg0)
    Return $00
End Function
