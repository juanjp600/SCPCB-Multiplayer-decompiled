Function hideroomdoors%(arg0.rooms, arg1.doors, arg2%)
    Local local0%
    If (arg0\Field74 = $00) Then
        For local0 = $01 To arg0\Field31 Step $01
            If (arg0\Field30[local0] <> Null) Then
                If (arg0\Field30[local0] <> arg1) Then
                    If (arg0\Field30[local0]\Field0 <> $00) Then
                        entityalpha(arg0\Field30[local0]\Field0, 0.0)
                    EndIf
                    If (arg0\Field30[local0]\Field2 <> $00) Then
                        If (arg0\Field30[local0]\Field9 <> $01) Then
                            entityalpha(arg0\Field30[local0]\Field2, 0.0)
                        EndIf
                    EndIf
                    If (arg0\Field30[local0]\Field1 <> $00) Then
                        entityalpha(arg0\Field30[local0]\Field1, 0.0)
                    EndIf
                    If (arg0\Field30[local0]\Field3[$00] <> $00) Then
                        entityalpha(arg0\Field30[local0]\Field3[$00], 0.0)
                    EndIf
                    If (arg0\Field30[local0]\Field3[$01] <> $00) Then
                        entityalpha(arg0\Field30[local0]\Field3[$01], 0.0)
                    EndIf
                EndIf
            EndIf
        Next
        arg0\Field74 = $01
    EndIf
    Return $00
End Function
