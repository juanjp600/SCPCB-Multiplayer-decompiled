Function multiplayer_animateviewmodel%()
    Local local0%
    Local local1.breachtypes
    Local local2%
    Local local4%
    Local local5%
    Local local10%
    Local local11%
    Local local18%
    local0 = myplayer\Field51
    If (spectate\Field1 <> $FFFFFFFF) Then
        If (spectate\Field0 = $01) Then
            local0 = player[spectate\Field1]\Field51
        EndIf
    EndIf
    If (showscpviewmodel = $00) Then
        local0 = $00
    EndIf
    If (myplayer\Field74 <> local0) Then
        local1 = getbreachtype(myplayer\Field74)
        If (local1\Field20 <> $00) Then
            hideentity(local1\Field20)
        EndIf
    EndIf
    myplayer\Field74 = local0
    local1 = getbreachtype(local0)
    If (local1\Field20 <> $00) Then
        If (spectate\Field1 <> $FFFFFFFF) Then
            If (spectate\Field0 = $01) Then
                If (player[spectate\Field1] <> Null) Then
                    If (player[spectate\Field1]\Field55 < $1E) Then
                        prev_player_move = player_move
                        player_move = player[spectate\Field1]\Field55
                        If (player_move_timed = $00) Then
                            player_move_timed = player[spectate\Field1]\Field56
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        positionentity(viewmodelpivot, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        rotateentity(viewmodelpivot, entitypitch(camera, $00), entityyaw(camera, $00), entityroll(camera, $00), $00)
        showentity(local1\Field20)
        local2 = local0
        If (local2 <> model_096) Then
            If (player_move_timed = $00) Then
                If (prev_player_move <> player_move) Then
                    Select prev_player_move
                        Case $0B,$05
                            Select player_move
                                Case $0D,$0C,$09,$0A,$07,$08,local4
                                    player_move_timed = $14
                                    setanimtime(local1\Field20, (Float getfirstpackedvalue(local1\Field21[player_move_timed])), $00)
                            End Select
                        Case $0D,$0C,$09,$0A,$07,$08,local4
                            Select player_move
                                Case $0B,$05
                                    player_move_timed = $15
                                    setanimtime(local1\Field20, (Float getsecondpackedvalue(local1\Field21[player_move_timed])), $00)
                            End Select
                    End Select
                    Return $00
                EndIf
            EndIf
            If (player_move_timed <> $00) Then
                If (getsecondpackedvalue(local1\Field21[player_move_timed]) <> $00) Then
                    animate2(local1\Field20, animtime(local1\Field20), getfirstpackedvalue(local1\Field21[player_move_timed]), getsecondpackedvalue(local1\Field21[player_move_timed]), local1\Field22[player_move_timed], $00)
                    If (0.0 <= local1\Field22[player_move_timed]) Then
                        If (((Float getsecondpackedvalue(local1\Field21[player_move_timed])) - 2.0) <= animtime(local1\Field20)) Then
                            Select player_move_timed
                                Case $14
                                    Select player_move
                                        Case $0B,$05
                                            player_move_timed = $15
                                            setanimtime(local1\Field20, (Float getsecondpackedvalue(local1\Field21[player_move_timed])), $00)
                                            Return $00
                                    End Select
                                Case $0F
                                    Select player_move
                                        Case $0D,$0C,$09,$0A,$07,$08,local4
                                            player_move_timed = $14
                                            setanimtime(local1\Field20, (Float getsecondpackedvalue(local1\Field21[player_move_timed])), $00)
                                            Return $00
                                        Case $0B,$05
                                            player_move_timed = $15
                                            setanimtime(local1\Field20, (Float getsecondpackedvalue(local1\Field21[player_move_timed])), $00)
                                            Return $00
                                    End Select
                            End Select
                            player_move_timed = $00
                        EndIf
                    ElseIf (animtime(local1\Field20) <= ((Float getfirstpackedvalue(local1\Field21[player_move_timed])) + 2.0)) Then
                        local18 = player_move_timed
                        If (local18 = $15) Then
                            Select player_move
                                Case $0D,$0C,$09,$0A,$07,$08,local4
                                    player_move_timed = $14
                                    Return $00
                            End Select
                        EndIf
                        player_move_timed = $00
                    EndIf
                    Return $00
                Else
                    player_move_timed = $00
                EndIf
            EndIf
        Else
            If (player_move_timed = $00) Then
                If (prev_player_move <> player_move) Then
                    Select prev_player_move
                        Case $0B,$0C,$0D,local4
                            local5 = player_move
                            If (local5 = $0E) Then
                                player_move_timed = $11
                                setanimtime(local1\Field20, (Float getfirstpackedvalue(local1\Field21[player_move_timed])), $00)
                            EndIf
                        Case $0E
                            Select player_move
                                Case $0D
                                    player_move_timed = $13
                                    setanimtime(local1\Field20, (Float getfirstpackedvalue(local1\Field21[player_move_timed])), $00)
                                Case $0B,$0C
                                    player_move_timed = $12
                                    setanimtime(local1\Field20, (Float getsecondpackedvalue(local1\Field21[player_move_timed])), $00)
                            End Select
                    End Select
                    Select prev_player_move
                        Case $0B,$05
                            Select player_move
                                Case $0C,$09,$0A,$07,$08
                                    player_move_timed = $14
                                    setanimtime(local1\Field20, (Float getfirstpackedvalue(local1\Field21[player_move_timed])), $00)
                            End Select
                        Case $0C,$09,$0A,$07,$08
                            Select player_move
                                Case $0B,$05
                                    player_move_timed = $15
                                    setanimtime(local1\Field20, (Float getsecondpackedvalue(local1\Field21[player_move_timed])), $00)
                            End Select
                    End Select
                    Return $00
                EndIf
            EndIf
            If (player_move_timed <> $00) Then
                If (getsecondpackedvalue(local1\Field21[player_move_timed]) <> $00) Then
                    animate2(local1\Field20, animtime(local1\Field20), getfirstpackedvalue(local1\Field21[player_move_timed]), getsecondpackedvalue(local1\Field21[player_move_timed]), local1\Field22[player_move_timed], $00)
                    If (0.0 <= local1\Field22[player_move_timed]) Then
                        If (((Float getsecondpackedvalue(local1\Field21[player_move_timed])) - 2.0) <= animtime(local1\Field20)) Then
                            local10 = player_move_timed
                            If (local10 = $11) Then
                                local11 = player_move
                                If (local11 = $0D) Then
                                    player_move_timed = $12
                                    Return $00
                                EndIf
                            EndIf
                            player_move_timed = $00
                        EndIf
                        Return $00
                    Else
                        If (animtime(local1\Field20) <= ((Float getfirstpackedvalue(local1\Field21[player_move_timed])) + 2.0)) Then
                            player_move_timed = $00
                        EndIf
                        Return $00
                    EndIf
                Else
                    player_move_timed = $00
                EndIf
            EndIf
        EndIf
        If (player_move >= $1E) Then
            player_move = $0B
        EndIf
        If (local1\Field21[player_move] <> $00) Then
            animate2(local1\Field20, animtime(local1\Field20), getfirstpackedvalue(local1\Field21[player_move]), getsecondpackedvalue(local1\Field21[player_move]), local1\Field22[player_move], $01)
        Else
            animate2(local1\Field20, animtime(local1\Field20), getfirstpackedvalue(local1\Field21[$0C]), getsecondpackedvalue(local1\Field21[$0C]), local1\Field22[$0C], $01)
        EndIf
    EndIf
    Return $00
End Function
