Function initroomforemitter%(arg0.emitters)
    Local local0%
    Return $00
    If (arg0\Field7 <> Null) Then
        For local0 = $00 To $13 Step $01
            If (arg0\Field7\Field77[local0] = Null) Then
                arg0\Field7\Field77[local0] = arg0
                Exit
            EndIf
        Next
    EndIf
    Return $00
End Function
