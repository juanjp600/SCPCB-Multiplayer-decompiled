Function createbullet%(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#, arg6#, arg7%)
    Local local0.bullets
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5.players
    Local local6#
    Local local7%
    Local local8%
    Local local9.npcs
    local0 = (New bullets)
    local0\Field0 = createcube($00)
    scaleentity(local0\Field0, 0.0003, 0.0003, 0.0, $00)
    entitycolor(local0\Field0, 9999.0, 9999.0, 0.0)
    entityshininess(local0\Field0, 100000.0)
    positionentity(local0\Field0, arg2, arg3, arg4, $00)
    rotateentity(local0\Field0, 0.0, arg6, 0.0, $00)
    rotateentity(local0\Field0, arg5, arg6, 0.0, $00)
    moveentity(local0\Field0, 0.0, 0.0, -0.5)
    entitypickmode(player[arg0]\Field69, $00, $01)
    local0\Field3 = arg0
    local0\Field1 = arg1
    local0\Field5 = arg7
    local1 = createpivot($00)
    positionentity(local1, arg2, arg3, arg4, $00)
    rotateentity(local1, arg5, arg6, 0.0, $00)
    moveentity(local1, 0.0, 0.0, -0.5)
    If (entitypick(local1, 30.0) <> 0) Then
        local3 = $00
        local4 = pickedentity()
        If (local4 <> $00) Then
            For local5 = Each players
                If (local5\Field59 = $00) Then
                    If ((((local4 = local5\Field64) Or (local4 = local5\Field69)) Or (local4 = local5\Field62)) <> 0) Then
                        If (((local5\Field30 <> local0\Field3) And (((mp_isafriend(player[local0\Field3]\Field36, local5\Field36) Or (server\Field21 = $00)) = $00) Or server\Field71)) <> 0) Then
                            entitypickmode(local5\Field69, $00, $01)
                            local2 = (server\Field62 = $00)
                            If (local2 = $00) Then
                                local2 = entityvisible(player[local0\Field3]\Field69, local5\Field69)
                            EndIf
                            If (local2 <> 0) Then
                                local6 = (rnd((getgundamage(local0\Field5) - 3.0), (getgundamage(local0\Field5) + 3.0)) - (Float (player[local5\Field30]\Field21 Shl $03)))
                                createsound("SFX\General\BulletHit.ogg", entityx(local5\Field64, $00), entityy(local5\Field64, $00), entityz(local5\Field64, $00), 10.0, 1.0)
                                If (server\Field57 <> 0) Then
                                    If (getscripts() <> 0) Then
                                        local7 = public_inqueue($12, $00)
                                        public_addparam(local7, (Str local0\Field3), $01)
                                        public_addparam(local7, (Str local5\Field30), $01)
                                        public_addparam(local7, (Str local6), $02)
                                        public_addparam(local7, (Str player[local0\Field3]\Field35), $01)
                                        callback($00)
                                    EndIf
                                    If (se_return_value\Field8 = $00) Then
                                        giveplayerhealth(local5\Field30, (- local6), ("was killed by " + player[local0\Field3]\Field15))
                                        If (local5\Field59 <> 0) Then
                                            If (getscripts() <> 0) Then
                                                local7 = public_inqueue($19, $00)
                                                public_addparam(local7, (Str local0\Field3), $01)
                                                public_addparam(local7, (Str local5\Field30), $01)
                                                public_addparam(local7, (Str player[local0\Field3]\Field35), $01)
                                                callback($00)
                                            EndIf
                                            local8 = breach_getcategorybytype(player[local0\Field3]\Field36, $01)
                                            If (((local5\Field73 = scientist_model) And (local8 = $06)) <> 0) Then
                                                breach_givetickets($01, 1.0)
                                            EndIf
                                            If (((local5\Field73 = classd_model) And (local8 = $07)) <> 0) Then
                                                breach_givetickets($00, 1.0)
                                            EndIf
                                        EndIf
                                        If ((mp_isascp(local5\Field36) Or (local5\Field36 = model_035)) <> 0) Then
                                            local8 = breach_getcategorybytype(player[local0\Field3]\Field36, $01)
                                            If (local8 = $07) Then
                                                breach_givetickets($00, 0.01)
                                            EndIf
                                            If (local8 = $06) Then
                                                breach_givetickets($01, 0.01)
                                            EndIf
                                        EndIf
                                    EndIf
                                Else
                                    udp_writebyte($2E)
                                    udp_writebyte(local0\Field3)
                                    udp_sendmessage(local5\Field30)
                                    If ((mp_isascp(local5\Field36) Or (local5\Field36 = model_035)) <> 0) Then
                                        local8 = breach_getcategorybytype(player[local0\Field3]\Field36, $01)
                                        If (local8 = $07) Then
                                            breach_givetickets($00, 0.01)
                                        EndIf
                                        If (local8 = $06) Then
                                            breach_givetickets($01, 0.01)
                                        EndIf
                                    EndIf
                                EndIf
                                local3 = $01
                            Else
                                local3 = $FFFFFFFF
                            EndIf
                            entitypickmode(local5\Field69, $02, $00)
                        Else
                            local3 = $FFFFFFFF
                        EndIf
                        Exit
                    EndIf
                EndIf
            Next
            If (local3 <> $01) Then
                For local9 = Each npcs
                    If (((local4 = local9\Field4) Or (local4 = local9\Field0)) <> 0) Then
                        If (((local9\Field5 = $15) Or (local9\Field5 = $0B)) <> 0) Then
                            local9\Field59 = (Int ((Float (local9\Field59 - $14)) + rnd(1.0, 3.0)))
                            If (local9\Field59 < $01) Then
                                local9\Field48 = $01
                            EndIf
                        EndIf
                        local3 = $01
                        Exit
                    EndIf
                Next
            EndIf
        EndIf
    EndIf
    entitypickmode(player[arg0]\Field69, $02, $00)
    freeentity(local0\Field0)
    freeentity(local1)
    Delete local0
    Return $00
End Function
