Function mp_interactobject%(arg0.rooms, arg1%, arg2#, arg3%, arg4%)
    Local local0%
    If ((((((((menuopen Lor invopen) Lor consoleopen) Lor i_294\Field0) Lor (otheropen <> Null)) Lor (d_i\Field6 <> Null)) Lor (selectedscreen <> Null)) Lor (Int me\Field0)) <> 0) Then
        Return $00
    EndIf
    Select arg4
        Case $00
            local0 = arg0\Field11[arg1]
        Case $01
            local0 = arg0\Field15[arg1]\Field0
    End Select
    If ((((grabbedentity <> $00) And (grabbedentity <> local0)) Lor (local0 = $00)) <> 0) Then
        Return $00
    EndIf
    If ((arg2 * arg2) > entitydistancesquared(me\Field60, local0)) Then
        If (entitypick(camera, arg2) = local0) Then
            handentity = local0
            Select arg3
                Case $00
                    If (mo\Field0 <> 0) Then
                        If (mp_ishoster() <> 0) Then
                            mp_server_interactobject(ue_players[mp_getmyindex()], arg1, arg4)
                            Return $01
                        EndIf
                        mp_client_interactobject(arg1, arg4)
                        Return $01
                    EndIf
                Case $01
                    If (mo\Field2 <> 0) Then
                        Return $01
                    EndIf
                Case $02
                    If (mo\Field6 <> 0) Then
                        If (mp_ishoster() <> 0) Then
                            mp_server_interactobject(ue_players[mp_getmyindex()], arg1, arg4)
                            Return $01
                        EndIf
                        mp_client_interactobject(arg1, arg4)
                        Return $01
                    EndIf
            End Select
        EndIf
    EndIf
    Return $00
    Return $00
End Function
