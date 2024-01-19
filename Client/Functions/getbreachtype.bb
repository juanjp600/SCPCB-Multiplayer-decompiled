Function getbreachtype.breachtypes(arg0%)
    If (breachtypesarray[arg0] = Null) Then
        Return breachtypesarray[classd_model]
    EndIf
    Return breachtypesarray[arg0]
    Return Null
End Function
