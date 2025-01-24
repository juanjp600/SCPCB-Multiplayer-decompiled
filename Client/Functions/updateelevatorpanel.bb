Function updateelevatorpanel%(arg0.doors)
    Local local0%
    Local local1%
    If (arg0\Field35 <> 0) Then
        local0 = $00
    Else
        local0 = $01
    EndIf
    For local1 = $00 To $01 Step $01
        If (arg0\Field24[local1] <> $00) Then
            entitytexture(arg0\Field24[local1], d_i\Field5[local0], $00, $00)
        EndIf
    Next
    arg0\Field28 = $01
    Return $00
End Function
