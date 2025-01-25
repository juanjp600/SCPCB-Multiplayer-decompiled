Function mp_initializedoor%(arg0.doors)
    Local local0%
    For local0 = $01 To $1F3 Step $01
        If (mp_doors[local0] = Null) Then
            mp_doors[local0] = arg0
            arg0\Field39 = local0
            Exit
        EndIf
    Next
    Return $00
End Function
