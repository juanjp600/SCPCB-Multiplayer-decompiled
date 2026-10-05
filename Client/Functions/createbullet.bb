Function createbullet%(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#, arg6#, arg7%)
    Local local0#
    Local local1#
    Local local2#
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7#
    Local local8#
    Local local9#
    Local local10.players
    Local local11.particles
    Local local12#
    Local local13%
    Local local14%
    Local local15.decals
    Local local16%
    local0 = arg2
    local1 = arg3
    local2 = arg4
    If (arg0 = myplayer\Field0) Then
        local0 = entityx(eqquipedgun\Field25, $01)
        local1 = entityy(eqquipedgun\Field25, $01)
        local2 = entityz(eqquipedgun\Field25, $01)
    EndIf
    local3 = copyentity(g_model\Field2, $00)
    showentity(local3)
    rotateentity(local3, arg5, arg6, 0.0, $00)
    tformvector(0.0, 0.0, 500.0, local3, $00)
    positionentity(local3, local0, local1, local2, $00)
    rotateentity(local3, 0.0, arg6, 0.0, $00)
    rotateentity(local3, arg5, arg6, 0.0, $00)
    If (bulletscount > $C350) Then
        removebullet($00)
    EndIf
    local4 = addbullet(local3, 1.5, 100.0, arg0)
    If (arg0 > $00) Then
        If (arg0 = myplayer\Field0) Then
            entitypickmode(player[arg0]\Field13, $00, $01)
        EndIf
        entitypickmode(player[arg0]\Field19, $00, $00)
    EndIf
    local5 = linepick(arg2, arg3, arg4, tformedx(), tformedy(), tformedz(), 0.0)
    If (local5 <> 0) Then
        local6 = $00
        local7 = pickedx()
        local8 = pickedy()
        local9 = pickedz()
        If (arg7 <> 0) Then
            For local10 = Each players
                If ((((local5 = local10\Field12) Or (local5 = local10\Field19)) Or (local5 = local10\Field13)) <> 0) Then
                    local6 = $01
                    If (udp_getstream() <> 0) Then
                        If (networkserver\Field15 <> 0) Then
                            udp_writebyte($2E)
                            udp_writebyte(arg0)
                            udp_sendmessage(local10\Field0)
                            createsound("SFX\General\BulletHit.ogg", local7, local8, local9, 10.0, 1.0)
                        EndIf
                        Exit
                    EndIf
                EndIf
            Next
        ElseIf (((((local5 = myplayer\Field12) Or (local5 = myplayer\Field19)) Or (local5 = myplayer\Field13)) Or (local5 = collider)) <> 0) Then
            local6 = $01
        EndIf
        If (local6 <> 0) Then
            If (debughud <> 0) Then
                drawdebugline(arg2, arg3, arg4, local7, local8, local9, $FF, $00, $00, $3E8)
            EndIf
            If (particleamount > $01) Then
                local11 = createparticle(local7, local8, local9, $05, 0.06, 0.2, $50, 1.0, $01)
                local11\Field6 = 0.001
                local11\Field13 = 0.0
                local11\Field3 = 0.8
                local11\Field12 = -0.02
            EndIf
        Else
            If (debughud <> 0) Then
                drawdebugline(arg2, arg3, arg4, local7, local8, local9, $FF, $FF, $00, $3E8)
            EndIf
            local12 = distance3(arg2, arg3, arg4, local7, local8, local9)
            If (100.0 > local12) Then
                If (particleamount > $01) Then
                    local13 = rand($01, $03)
                    If (50.0 > local12) Then
                        For local14 = $00 To local13 Step $01
                            local11 = createparticle(local7, local8, local9, $06, rnd(0.08, 0.2), rnd(-0.01, 0.01), $14, 1.0, $01)
                            local11\Field6 = rnd(0.01, 0.02)
                            local11\Field3 = rnd(0.4, 0.6)
                            local11\Field12 = -0.04
                            entityalpha(local11\Field0, local11\Field3)
                            aligntovector(local11\Field1, (rnd(-15.0, 15.0) + (- pickednx())), (rnd(-15.0, 15.0) + (- pickedny())), (rnd(-15.0, 15.0) + (- pickednz())), $03, 1.0)
                            setemitter(local11\Field1, particleeffect[$00], $01, $01)
                        Next
                    EndIf
                EndIf
                If (removedecals = $00) Then
                    local15 = createdecal(rand($0D, $0E), local7, local8, local9, 0.0, 0.0, 0.0, 1.0, 1.0)
                    aligntovector(local15\Field0, (- pickednx()), (- pickedny()), (- pickednz()), $03, 1.0)
                    moveentity(local15\Field0, 0.0, 0.0, -0.005)
                    entityfx(local15\Field0, $09)
                    entityblend(local15\Field0, $02)
                    local15\Field10 = 500.0
                    local15\Field2 = rnd(0.028, 0.034)
                    scalesprite(local15\Field0, local15\Field2, local15\Field2)
                    entityparent(local15\Field0, local5, $01)
                EndIf
                local16 = playsound_raw(gunshot3sfx, camera, local7, local8, local9, 3.0, rnd(0.6, 1.0))
                channelpitch(local16, rand($C350, $EA60))
            EndIf
        EndIf
        aligntovector(local3, (local7 - local0), (local8 - local1), (local9 - local2), $03, 1.0)
    EndIf
    If (((arg0 > $00) And arg7) <> 0) Then
        If (arg0 = myplayer\Field0) Then
            entitypickmode(player[arg0]\Field13, $01, $01)
        EndIf
        entitypickmode(player[arg0]\Field19, $02, $00)
    EndIf
    If (arg7 <> 0) Then
        Return local3
    Else
        Return local6
    EndIf
    Return $00
End Function
