Function mp_terminateplayer%(arg0.mp_player, arg1%, arg2%)
    Local local0%
    Local local1%
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7.mp_modelmeshpreset
    Local local8%
    Local local9.decals
    If (((mp_ishoster() And (arg0\Field4\Field4 = $00)) And ((arg0\Field4\Field34 = $00) Lor arg2)) <> 0) Then
        senddebuglog(((("Player: " + (Str arg0\Field5)) + " dead. Godmode is: ") + (Str arg0\Field4\Field34)))
        arg0\Field4\Field4 = $01
        local0 = (i_zone\Field0[$00] - (selectedcustommap = Null))
        local1 = (i_zone\Field0[$01] - (selectedcustommap = Null))
        local2 = (entityz(arg0\Field18, $00) / 8.0)
        arg0\Field4\Field16 = $00
        If ((Float local1) > local2) Then
            arg0\Field4\Field16 = $02
        ElseIf ((((Float local1) <= local2) And ((Float local0) > local2)) <> 0) Then
            arg0\Field4\Field16 = $01
        EndIf
        If (arg0\Field35\Field17 > $00) Then
            If (arg0\Field4\Field5 <> Null) Then
                arg0\Field4\Field5\Field11 = $00
            EndIf
            If (arg0\Field5 = mp_getmyindex()) Then
                local7 = getplayermodelmeshpreset(arg0\Field35\Field17)
                local3 = entityx(arg0\Field18, $00)
                local4 = (entityy(arg0\Field18, $00) + local7\Field9)
                local5 = entityz(arg0\Field18, $00)
                local6 = (entityyaw(arg0\Field18, $00) - local7\Field8)
            ElseIf (arg0\Field35\Field0 <> $00) Then
                local3 = entityx(arg0\Field35\Field0, $01)
                local4 = entityy(arg0\Field35\Field0, $01)
                local5 = entityz(arg0\Field35\Field0, $01)
                local6 = entityyaw(arg0\Field35\Field0, $01)
            EndIf
            arg0\Field4\Field5 = mp_createcorpse(local3, local4, local5, local6, arg0\Field35\Field17, arg0\Field35\Field18, arg0, $00, $FFFFFFFF, $FFFFFFFF)
            If (getplayermodel(arg0) = $02) Then
                mp_setcorpseexploredmodel(arg0\Field4\Field5, getpreviousplayermodel(arg0), getpreviousplayermodeltexture(arg0))
            EndIf
        EndIf
        If (arg1 <> 0) Then
            local8 = createpivot($00)
            positionentity(local8, (entityx(arg0\Field18, $00) + rnd(-0.8, 0.8)), (entityy(arg0\Field18, $00) - 0.05), (entityz(arg0\Field18, $00) + rnd(-0.8, 0.8)), $00)
            turnentity(local8, 90.0, 0.0, 0.0, $00)
            entitypick(local8, 0.3)
            local9 = createdecal($07, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 1.0, $00, $01, $00, $00, $00)
            local9\Field4 = (1.0 / 400.0)
            If (mp_rooms[arg0\Field22] <> Null) Then
                entityparent(local9\Field0, mp_rooms[arg0\Field22]\Field2, $01)
            EndIf
            mp_server_synchronizedecal(local9, arg0\Field22)
            freeentity(local8)
            local8 = $00
        EndIf
        arg0\Field3 = $00
    EndIf
    Return $00
End Function
