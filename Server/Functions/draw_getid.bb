Function draw_getid%(arg0%)
    Local local0%
    For local0 = $01 To $1F Step $01
        If (player[arg0]\Field43[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
End Function
