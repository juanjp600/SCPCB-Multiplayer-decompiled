Function createbullet.bullets(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#, arg6#)
    Local local0.bullets
    Local local1%
    Local local2%
    Local local3%
    Local local4.players
    Local local5.npcs
    Local local6.particles
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11.decals
    local0 = (New bullets)
    local0\Field0 = createcube($00)
    scaleentity(local0\Field0, 0.0003, 0.0003, 0.0, $00)
    entitycolor(local0\Field0, 9999.0, 9999.0, 0.0)
    entityshininess(local0\Field0, 100000.0)
    positionentity(local0\Field0, arg2, arg3, arg4, $00)
    rotateentity(local0\Field0, 0.0, arg6, 0.0, $00)
    rotateentity(local0\Field0, arg5, arg6, 0.0, $00)
    moveentity(local0\Field0, 0.0, 0.0, -0.5)
    If (arg0 > $00) Then
        If (arg0 = myplayer\Field0) Then
            entitypickmode(player[arg0]\Field13, $00, $01)
        EndIf
        entitypickmode(player[arg0]\Field19, $00, $00)
    EndIf
    local0\Field1 = arg1
    local0\Field3 = arg0
    local1 = createpivot($00)
    positionentity(local1, arg2, arg3, arg4, $00)
    rotateentity(local1, arg5, arg6, 0.0, $00)
    moveentity(local1, 0.0, 0.0, -0.5)
    If (entitypick(local1, 1000.0) <> $00) Then
        local2 = $00
        local3 = pickedentity()
        For local4 = Each players
            If ((((local3 = local4\Field12) Or (local3 = local4\Field19)) Or (local3 = local4\Field13)) <> 0) Then
                local2 = $01
                If (udp_getstream() <> 0) Then
                    If (networkserver\Field18 <> 0) Then
                        udp_writebyte($2E)
                        udp_writebyte(local0\Field3)
                        udp_sendmessage(local4\Field0)
                        createsound("SFX\General\BulletHit.ogg", entityx(local4\Field12, $00), entityy(local4\Field12, $00), entityz(local4\Field12, $00), 10.0, 1.0)
                    EndIf
                EndIf
                Exit
            EndIf
        Next
        If (local2 <> $01) Then
            For local5 = Each npcs
                If (((local3 = local5\Field4) Or (local3 = local5\Field0)) <> 0) Then
                    If (udp_getstream() <> 0) Then
                        createsound("SFX\General\BulletHit.ogg", entityx(local3, $00), entityy(local3, $00), entityz(local3, $00), 10.0, 1.0)
                    EndIf
                    If (((local5\Field5 = $15) Or (local5\Field5 = $0B)) <> 0) Then
                        local5\Field59 = (Int ((Float (local5\Field59 - $14)) + rnd(1.0, 3.0)))
                        If (local5\Field59 < $01) Then
                            local5\Field48 = $01
                        EndIf
                    EndIf
                    local2 = $01
                    Exit
                EndIf
            Next
        EndIf
        If (local2 = $01) Then
            local6 = createparticle(pickedx(), pickedy(), pickedz(), $05, 0.06, 0.2, $50)
            local6\Field9 = 0.001
            local6\Field16 = 0.003
            local6\Field6 = 0.8
            local6\Field15 = -0.02
        Else
            local6 = createparticle(pickedx(), pickedy(), pickedz(), $00, 0.03, 0.0, $50)
            local6\Field9 = 0.001
            local6\Field16 = 0.003
            local6\Field6 = 0.8
            local6\Field15 = -0.01
            rotateentity(local6\Field1, (entitypitch(local0\Field0, $00) - 180.0), entityyaw(local0\Field0, $00), 0.0, $00)
            If (local7 = $01) Then
                local8 = rand($AA, $BE)
                local9 = rand($00, $0A)
            EndIf
            For local10 = $00 To rand($02, $03) Step $01
                local6 = createparticle(pickedx(), pickedy(), pickedz(), $00, 0.006, 0.003, $50)
                local6\Field9 = 0.02
                local6\Field6 = 0.8
                local6\Field15 = -0.01
                rotateentity(local6\Field1, entitypitch(local0\Field0, $00), entityyaw(local0\Field0, $00), 0.0, $00)
            Next
            local11 = createdecal(rand($0D, $0E), pickedx(), pickedy(), pickedz(), 0.0, 0.0, 0.0, 1.0, 1.0)
            aligntovector(local11\Field0, (- pickednx()), (- pickedny()), (- pickednz()), $03, 1.0)
            moveentity(local11\Field0, 0.0, 0.0, -0.001)
            entityfx(local11\Field0, $01)
            local11\Field10 = 1400.0
            entityblend(local11\Field0, $02)
            local11\Field2 = rnd(0.028, 0.034)
            scalesprite(local11\Field0, local11\Field2, local11\Field2)
            playsound2(gunshot3sfx, camera, local3, 5.0, rnd(0.8, 1.0))
            entityparent(local11\Field0, local3, $01)
        EndIf
    EndIf
    freeentity(local1)
    If (arg0 > $00) Then
        If (arg0 = myplayer\Field0) Then
            entitypickmode(player[arg0]\Field13, $01, $01)
        EndIf
        entitypickmode(player[arg0]\Field19, $02, $00)
    EndIf
    entitypickmode(local0\Field0, $00, $01)
    If (enablebullets = $00) Then
        freeentity(local0\Field0)
        Delete local0
    EndIf
    Return local0
    Return Null
End Function
