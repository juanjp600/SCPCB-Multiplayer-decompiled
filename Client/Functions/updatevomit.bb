Function updatevomit%()
    Local local0.decals
    Local local1%
    Local local2#
    catcherrors("UpdateVomit()")
    local2 = (fps\Field7[$00] / 70.0)
    If (0.0 < me\Field21) Then
        me\Field21 = max((me\Field21 - local2), 0.0)
        me\Field23 = 2.0
    EndIf
    If (0.0 < me\Field26) Then
        me\Field26 = (me\Field26 - local2)
        If ((millisec Mod $640) < rand($C8, $190)) Then
            If (0.0 = me\Field49) Then
                me\Field49 = (rnd(10.0, 20.0) * 70.0)
            EndIf
            me\Field23 = rnd(0.0, 2.0)
        EndIf
        If (((rand($32, $01) = $32) And ((millisec Mod $FA0) < $C8)) <> 0) Then
            playsound_strict(coughsfx((((wi\Field0 > $00) Lor (i_1499\Field0 > $00)) Lor (wi\Field2 > $00)), rand($00, $02)), $01, $01)
        EndIf
        If (((10.0 > me\Field26) And (2.0 > rnd(0.0, (me\Field26 * 500.0)))) <> 0) Then
            If (((channelplaying(vomitchn) = $00) And (me\Field27 = $00)) <> 0) Then
                vomitchn = playsound_strict(loadtempsound((("SFX\SCP\294\Retch" + (Str rand($00, $01))) + ".ogg")), $01, $01)
                me\Field27 = (millisecs() + $32)
            EndIf
        EndIf
        If (((me\Field27 > millisecs()) And (me\Field27 <> $00)) <> 0) Then
            mo\Field8 = (mo\Field8 + 1.0)
        Else
            me\Field27 = $00
        EndIf
    ElseIf (0.0 > me\Field26) Then
        me\Field26 = (me\Field26 - local2)
        If (-5.0 < me\Field26) Then
            If ((millisec Mod $190) < $32) Then
                me\Field23 = 4.0
            EndIf
            mo\Field7 = 0.0
            makemeunplayable()
        Else
            me\Field9 = $01
        EndIf
        If (me\Field25 = $00) Then
            me\Field49 = 2800.0
            snd_i\Field54 = loadsound_strict("SFX\SCP\294\Vomit.ogg")
            mp_synchronizesound("SFX\SCP\294\Vomit.ogg", $01, ue_players[mp_getmyindex()], 10.0, 1.0, 0.0, 0.0, 0.0)
            vomitchn = playsound_strict(snd_i\Field54, $01, $01)
            me\Field33 = me\Field31
            me\Field34 = me\Field32
            If (me\Field39 = $00) Then
                setcrouch($01)
            EndIf
            me\Field14 = 630.0
            If (-200.0 > me\Field5) Then
                me\Field31 = 1.5
                me\Field32 = 70.0
            Else
                me\Field31 = 0.0
                me\Field32 = 0.0
            EndIf
            local1 = createpivot($00)
            positionentity(local1, entityx(camera, $00), (entityy(me\Field60, $00) - 0.05), entityz(camera, $00), $00)
            turnentity(local1, 90.0, 0.0, 0.0, $00)
            entitypick(local1, 0.3)
            local0 = createdecal($05, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, 180.0, 0.0, 0.001, 1.0, $00, $01, $00, rand($C8, $FF), $00)
            local0\Field4 = 0.001
            local0\Field5 = 0.6
            entityparent(local0\Field0, playerroom\Field2, $01)
            freeentity(local1)
            local1 = $00
            me\Field25 = $01
        EndIf
        mo\Field8 = (mo\Field8 + max(((me\Field26 / 10.0) + 1.0), 0.0))
        If (-15.0 > me\Field26) Then
            freesound_strict(snd_i\Field54)
            snd_i\Field54 = $00
            me\Field26 = 0.0
            If (0.0 = me\Field0) Then
                playsound_strict(breathsfx($00, $00), $01, $01)
            EndIf
            me\Field31 = me\Field33
            me\Field32 = me\Field34
            me\Field25 = $00
        EndIf
    EndIf
    catcherrors("Uncaught: UpdateVomit()")
    Return $00
End Function
