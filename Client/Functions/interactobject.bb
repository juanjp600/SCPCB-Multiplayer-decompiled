Function interactobject%(arg0%, arg1#, arg2%)
    If (((((((((menuopen Lor invopen) Lor consoleopen) Lor i_294\Field0) Lor (otheropen <> Null)) Lor (d_i\Field6 <> Null)) Lor (selectedscreen <> Null)) Lor (Int me\Field0)) Lor (grabbedentity <> $00)) <> 0) Then
        Return $00
    EndIf
    If ((arg1 * arg1) > entitydistancesquared(me\Field60, arg0)) Then
        If (entitypick(camera, arg1) = arg0) Then
            handentity = arg0
            Select arg2
                Case $00
                    If (mo\Field0 <> 0) Then
                        Return $01
                    EndIf
                Case $01
                    If (mo\Field2 <> 0) Then
                        Return $01
                    EndIf
                Case $02
                    If (mo\Field6 <> 0) Then
                        Return $01
                    EndIf
            End Select
        EndIf
    EndIf
    Return $00
    Return $00
End Function
