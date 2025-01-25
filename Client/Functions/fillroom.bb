Function fillroom%(arg0.rooms)
    Local local0.doors
    Local local1.doors
    Local local2.securitycams
    Local local3.decals
    Local local4.rooms
    Local local5.forest
    Local local6.emitter
    Local local7.items
    Local local8.items
    Local local9%
    Local local10%
    Local local11.lights
    Local local12#
    Local local13#
    Local local14#
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local20$
    Local local21%
    Local local22%
    Local local23%
    Local local24#
    Local local25%
    Local local26%
    Local local27%
    Local local28%
    Local local29#
    Local local30$
    Local local31%
    Local local32#
    Local local33#
    Local local38%
    Local local48%
    Local local50.tempscreens
    Local local51.tempwaypoints
    Local local52.templights
    Local local53.tempprops
    Local local54.tempsoundemitters
    catcherrors("FillRoom()")
    Select arg0\Field7\Field6
        Case $00
            createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 2.0), 0.0, $00, $00, $03, $00, $00)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 1.0), (arg0\Field4 + 1.5), (arg0\Field5 + 2.5), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 180.0
            local2\Field9 = 45.0
            arg0\Field11[$00] = loadmesh_strict("GFX\Map\Props\watches.b3d", $00)
            scaleentity(arg0\Field11[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            rotateentity(arg0\Field11[$00], 0.0, 128.0, 270.0, $00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - 2.574219), (arg0\Field4 + (1.0 / 1.924812)), (arg0\Field5 + (1.0 / 1.236715)), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = loadmesh_strict("GFX\Map\Props\rubber_duck.b3d", $00)
            scaleentity(arg0\Field11[$01], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            rotateentity(arg0\Field11[$01], 0.0, 260.0, 0.0, $00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - 2.574219), (arg0\Field4 + (1.0 / 1.924812)), (arg0\Field5 + 1.742188), $00)
            entityradius(arg0\Field11[$01], 0.2, 0.0)
            entitypickmode(arg0\Field11[$01], $01, $01)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = loadanimmesh_strict("GFX\Map\Props\penny.b3d", $00)
            scaleentity(arg0\Field11[$02], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$02], (arg0\Field3 - 2.402344), (arg0\Field4 + (1.0 / 1.924812)), (arg0\Field5 - (1.0 / 1.753425)), $00)
            entityradius(arg0\Field11[$02], 0.2, 0.0)
            entitypickmode(arg0\Field11[$02], $01, $01)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            If (key2_spawnrate = $06) Then
                local7 = createitem("White Key", $68, (arg0\Field3 - 2.066406), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 2.285156), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            local7 = createitem("Log of Anomalous Items", $00, (arg0\Field3 + 0.75), (arg0\Field4 + 0.375), (arg0\Field5 + 1.800781), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("S-NAV Navigator", $49, (arg0\Field3 + 0.75), (arg0\Field4 + 0.375), (arg0\Field5 - 0.875), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Playing Card", $63, (arg0\Field3 + 0.75), (arg0\Field4 + 1.125), (arg0\Field5 + 1.679688), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery((arg0\Field3 + 0.75), (arg0\Field4 + 0.75), (arg0\Field5 - 1.015625))
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Clipboard", $2D, (arg0\Field3 + 0.75), (arg0\Field4 + 0.75), (arg0\Field5 + (1.0 / 2.327273)), $00, $00, $00, 1.0, $00)
            local7\Field17 = local7\Field4\Field7
            setanimtime(local7\Field3, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local8 = createitem("Document SCP-966", $00, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
            local8\Field26 = local7\Field19
            local8\Field15 = $00
            local8\Field16 = $FFFFFFFF
            local7\Field18[$00] = local8
            hideentity(local8\Field2)
            local8 = createitem("Document SCP-1025", $00, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
            local8\Field26 = local7\Field19
            local8\Field15 = $00
            local8\Field16 = $FFFFFFFF
            local7\Field18[$01] = local8
            hideentity(local8\Field2)
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 3.0))
        Case $01
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 + 3.070312), arg0\Field4, $00, $03, $00, $00, $00)
            local0\Field23 = $00
            local0\Field16 = $01
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$00] = local0
        Case $4A
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 + 4.695312), arg0\Field4, $00, $03, $00, $00, $00)
            local0\Field23 = $00
            local0\Field16 = $01
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            local0 = createdoor(arg0, (arg0\Field3 - 3.6875), (arg0\Field4 + 1.25), (arg0\Field5 + 3.609375), 180.0, $00, $00, $00, $00, $00)
            local0\Field23 = $00
            local0\Field16 = $01
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$00] = local0
        Case $02
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 2.5), 0.0, (i_005\Field0 = $02), $00, $06, $00, $00)
            arg0\Field14[$00] = local0
            local2 = createsecuritycam(arg0, arg0\Field3, (arg0\Field4 + 1.621094), (arg0\Field5 + 1.65625), 30.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 180.0
            local2\Field9 = 30.0
            local7 = createitem("Document SCP-005", $00, (arg0\Field3 + 1.96875), (arg0\Field4 + 0.59375), (arg0\Field5 - (1.0 / 0.512)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            If (i_005\Field0 = $01) Then
                local7 = createitem("SCP-005", $08, arg0\Field3, (arg0\Field4 + (1.0 / 1.003922)), (arg0\Field5 + (1.0 / 1.07563)), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
                local22 = loadtexture_strict("GFX\Map\Textures\Door01_Corrosive.png", $01, $00, $01)
                entitytexture(arg0\Field14[$00]\Field0, local22, $00, $00)
                entitytexture(arg0\Field14[$00]\Field1, local22, $00, $00)
                entitytexture(arg0\Field14[$00]\Field2, local22, $00, $00)
                deletesingletextureentryfromcache(local22, $00)
                local22 = $00
                arg0\Field14[$00]\Field27 = $01
                local3 = createdecal($00, (arg0\Field3 - 1.414062), (arg0\Field4 + 0.005), (arg0\Field5 - 1.640625), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0, $00, $01, $00, $00, $00)
                entityparent(local3\Field0, arg0\Field2, $01)
            ElseIf (i_005\Field0 = $03) Then
                local7 = createitem("Note from Maynard", $00, arg0\Field3, (arg0\Field4 + (1.0 / 1.003922)), (arg0\Field5 + (1.0 / 1.07563)), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 3.242188))
        Case $03
            local0 = createdoor(arg0, (arg0\Field3 - 2.5), (arg0\Field4 + 1.5), (arg0\Field5 + 8.371094), -90.0, $00, $00, $00, $00, $00)
            If (mp_menu_isconnection() = $00) Then
                local0\Field4 = $01
                local0\Field16 = $01
                local0\Field23 = $00
                freeentity(local0\Field3[$00])
                local0\Field3[$00] = $00
                freeentity(local0\Field1)
                local0\Field1 = $00
            Else
                local0 = createdoor(arg0, (arg0\Field3 - 6.900781), (arg0\Field4 + 1.484375), (arg0\Field5 + 17.08984), 90.0, $00, $00, $00, $00, $00)
                local0\Field4 = $01
                local0\Field16 = $01
                local0\Field23 = $00
                freeentity(local0\Field3[$00])
                local0\Field3[$00] = $00
                local0 = createdoor(arg0, (arg0\Field3 - 10.35312), (arg0\Field4 + 1.484375), (arg0\Field5 + 17.08984), -90.0, $00, $00, $00, $00, $00)
                local0\Field4 = $01
                local0\Field16 = $01
                local0\Field23 = $00
                freeentity(local0\Field3[$00])
                local0\Field3[$00] = $00
                local0 = createdoor(arg0, (arg0\Field3 - 10.35312), (arg0\Field4 + 1.484375), (arg0\Field5 + 26.0875), -90.0, $00, $00, $00, $00, $00)
                local0\Field4 = $01
                local0\Field16 = $01
                local0\Field23 = $00
                freeentity(local0\Field3[$00])
                local0\Field3[$00] = $00
                freeentity(local0\Field1)
                local0\Field1 = $00
                local0 = createdoor(arg0, (arg0\Field3 - 8.617188), (arg0\Field4 + 1.484375), (arg0\Field5 + 2.238281), 0.0, $00, $00, $00, $00, $00)
                local0\Field4 = $01
                local0\Field16 = $01
                local0\Field23 = $00
                freeentity(local0\Field3[$00])
                local0\Field3[$00] = $00
                freeentity(local0\Field1)
                local0\Field1 = $00
                local0 = createdoor(arg0, (arg0\Field3 - 6.869531), (arg0\Field4 + 1.484375), (arg0\Field5 + 26.0875), -90.0, $00, $00, $00, $00, $00)
                local0 = createdoor(arg0, (arg0\Field3 - 8.617188), (arg0\Field4 + 1.484375), (arg0\Field5 + 14.49375), 0.0, $00, $00, $00, $00, $00)
            EndIf
            createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 + 12.74219), 180.0, $01, $00, $05, $00, $00)
            createdoor(arg0, (arg0\Field3 + 8.5), (arg0\Field4 + 3.0), (arg0\Field5 + 16.24219), 90.0, $01, $00, $05, $00, $00)
            createdoor(arg0, (arg0\Field3 + 8.3125), (arg0\Field4 + 1.5), (arg0\Field5 + 6.367188), 0.0, $01, $00, $02, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 + 1.0625), arg0\Field4, arg0\Field5, 90.0, $00, $04, $FFFFFFFB, $00, $00)
            local0\Field4 = $01
            local0 = createdoor(arg0, (arg0\Field3 + 15.625), (arg0\Field4 + 1.5), (arg0\Field5 + 14.74219), 90.0, $01, $03, $00, $00, $00)
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 10.5625), (arg0\Field4 + 1.5), (arg0\Field5 + 10.55469), 90.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$01] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 5.4375), (arg0\Field4 + 1.5), (arg0\Field5 + 8.371094), 90.0, $01, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            arg0\Field14[$02] = local0
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 + 4.0), 0.0, $01, $00, $00, $00, $00)
            local0\Field20 = $00
            arg0\Field14[$03] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 4.554688), (arg0\Field4 + 1.499609), (arg0\Field5 + 9.324219), 180.0, $01, $06, $00, $00, $00)
            local0\Field23 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) - 0.048), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.048), $01)
            arg0\Field14[$04] = local0
            arg0\Field11[$00] = loadmesh_strict("GFX\Map\Props\table_a.b3d", $00)
            scaleentity(arg0\Field11[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            rotateentity(arg0\Field11[$00], 90.0, 45.0, 0.0, $00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 1.0625), (arg0\Field4 + (1.0 / 25.6)), (arg0\Field5 + 8.804688), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = loadmesh_strict("GFX\Map\Props\cabinet_c.b3d", $00)
            scaleentity(arg0\Field11[$01], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            rotateentity(arg0\Field11[$01], 0.0, 225.0, 90.0, $00)
            positionentity(arg0\Field11[$01], (arg0\Field3 + 1.75), (arg0\Field4 + (1.0 / 25.6)), (arg0\Field5 + 8.398438), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = loadmesh_strict("GFX\Map\Props\ventilation_grate.b3d", $00)
            scaleentity(arg0\Field11[$02], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            entitytype(arg0\Field11[$02], $01, $00)
            positionentity(arg0\Field11[$02], (arg0\Field3 + 11.5), (arg0\Field4 + 4.5), (arg0\Field5 + 10.24219), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 2.015625), (arg0\Field4 + 1.375), (arg0\Field5 + 8.371094), 20.0, $01, (arg0\Field3 + 5.679688), (arg0\Field4 + 2.375), (arg0\Field5 + 9.617188), 0.0, 90.0, 0.0)
            showentity(local2\Field0)
            showentity(local2\Field1)
            local2\Field8 = 270.0
            local2\Field9 = 45.0
            local3 = createdecal($00, (arg0\Field3 + 1.0625), (arg0\Field4 + 0.005), (arg0\Field5 + 9.023438), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($00, (arg0\Field3 + 1.78125), (arg0\Field4 + 0.005), (arg0\Field5 + 8.527344), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            For local25 = $00 To $04 Step $01
                Select local25
                    Case $00
                        local12 = 4299.0
                        local14 = 3316.0
                        local27 = $04
                    Case $01
                        local12 = 5184.0
                        local14 = 4302.0
                        local27 = $04
                    Case $02
                        local12 = 5216.0
                        local14 = 3310.0
                        local27 = $04
                    Case $03
                        local12 = 4314.0
                        local14 = 4033.0
                        local27 = $04
                    Case $04
                        local12 = 4972.0
                        local14 = 4017.0
                        local27 = $06
                End Select
                local3 = createdecal(local27, (arg0\Field3 + (local12 * (1.0 / 256.0))), (arg0\Field4 + 1.507812), (arg0\Field5 + (local14 * (1.0 / 256.0))), 90.0, 45.0, 0.0, ((((Float (local25 = $00)) * 0.44) + ((Float (local25 = $01)) * 1.2)) + ((Float (local25 > $01)) * 0.54)), rnd(0.8, 1.0), $00, $01, $00, $00, $00)
                entityparent(local3\Field0, arg0\Field2, $01)
            Next
            If (s2imapcontains(unlockedachievements, "keter") <> 0) Then
                local3 = createdecal($16, (arg0\Field3 + 2.007812), (arg0\Field4 + (1.0 / 1.610063)), ((arg0\Field5 - (1.0 / 1.04065)) - 0.005), 0.0, 180.0, 0.0, 0.1, 1.0, $00, $01, $00, $00, $00)
                entityparent(local3\Field0, arg0\Field2, $01)
            EndIf
            If (s2imapcontains(unlockedachievements, "apollyon") <> 0) Then
                local3 = createdecal($17, (arg0\Field3 + 1.4375), (arg0\Field4 + (1.0 / 1.855072)), (arg0\Field5 + 0.71875), 0.0, 0.0, 0.0, 0.1, 1.0, $00, $01, $00, $00, $00)
                entityparent(local3\Field0, arg0\Field2, $01)
            EndIf
            local7 = createitem("Document SCP-173", $00, (arg0\Field3 + 3.277539), (arg0\Field4 + (1.0 / 1.479769)), (arg0\Field5 + 9.683946), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 + 7.226562), (arg0\Field4 + 1.972656), (arg0\Field5 + 4.246094), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            If (rand($03, $01) = $01) Then
                local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 + 7.5), (arg0\Field4 + 1.972656), (arg0\Field5 + 4.246094), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            local7 = createitem("Compact First Aid Kit", $36, (arg0\Field3 + 2.632812), (arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 + (1.0 / 1.376344)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            If (key2_spawnrate = $01) Then
                Select rand($04, $01)
                    Case $01
                        local12 = 2255.0
                        local13 = 1015.0
                        local14 = 4618.0
                    Case $02
                        local12 = 339.0
                        local13 = 150.0
                        local14 = 2630.0
                    Case $03
                        local12 = 410.0
                        local13 = 150.0
                        local14 = 1120.0
                    Case $04
                        local12 = -124.0
                        local13 = 250.0
                        local14 = 3810.0
                End Select
                local7 = createitem("White Key", $68, (arg0\Field3 + (local12 * (1.0 / 256.0))), (arg0\Field4 + (local13 * (1.0 / 256.0))), (arg0\Field5 + (local14 * (1.0 / 256.0))), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            If (snavunlocked <> 0) Then
                local7 = createitem("S-NAV Navigator Ultimate", $4C, (arg0\Field3 + 1.59375), (arg0\Field4 + (1.0 / 1.706667)), (arg0\Field5 - (1.0 / 1.080169)), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            If (ereaderunlocked <> 0) Then
                local7 = createitem("E-Reader 30", $4F, (arg0\Field3 + 1.453125), (arg0\Field4 + (1.0 / 1.024)), (arg0\Field5 + (1.0 / 1.089362)), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            local6 = setemitter(arg0, (arg0\Field3 + 13.21875), (arg0\Field4 + (1.0 / 0.512)), (arg0\Field5 + 17.57812), $07)
            local6\Field11 = $02
        Case $04
            local0 = createdoor(arg0, (arg0\Field3 - 22.5), arg0\Field4, (arg0\Field5 + 4.75), 180.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 22.5), arg0\Field4, (arg0\Field5 + 1.25), 0.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 31.5), arg0\Field4, (arg0\Field5 + 4.75), 180.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 34.125), arg0\Field4, (arg0\Field5 + 3.0), 270.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 31.5), arg0\Field4, (arg0\Field5 - 11.0), 0.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 13.375), (arg0\Field4 - 1.5), (arg0\Field5 - 9.246094), 0.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 5.0625), arg0\Field4, (arg0\Field5 - 6.878906), 0.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 31.5), arg0\Field4, (arg0\Field5 + 1.25), 0.0, $01, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 25.375), arg0\Field4, (arg0\Field5 - 4.875), 90.0, $01, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 15.875), arg0\Field4, (arg0\Field5 - 4.875), 90.0, $01, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 8.820312), arg0\Field4, (arg0\Field5 - 3.921875), 180.0, $00, $06, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.048), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 + 2.25), arg0\Field4, (arg0\Field5 + 1.496094), 90.0, $00, $03, $00, $00, $00)
            local0\Field23 = $00
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$01] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 2.8125), arg0\Field4, (arg0\Field5 - 2.691406), 90.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$02] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 7.9375), arg0\Field4, (arg0\Field5 - 4.875), 90.0, $01, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            arg0\Field14[$03] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 16.0), arg0\Field4, (arg0\Field5 + 2.0), 0.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            local22 = loadtexture_strict("GFX\Map\Textures\Door02.jpg", $01, $00, $01)
            entitytexture(local0\Field0, local22, $00, $00)
            deletesingletextureentryfromcache(local22, $00)
            local22 = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$04] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 13.375), (arg0\Field4 - 1.5), (arg0\Field5 - (1.0 / 1.984496)), 0.0, $01, $00, $05, $00, $00)
            local0\Field23 = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field14[$05] = local0
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 3.703125), (arg0\Field4 + 0.3), (arg0\Field5 + 2.054688), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 + 3.828125), (arg0\Field4 + 0.3), (arg0\Field5 + 1.25), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 + 6.875), (arg0\Field4 + 0.4), (arg0\Field5 + 3.5625), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = loadrmesh("GFX\Map\cont1_173_intro_player_cell.rmesh", Null, $01)
            scaleentity(arg0\Field11[$03], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$03], arg0\Field3, arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = loadrmesh("GFX\Map\cont1_173_intro_cells.rmesh", Null, $00)
            scaleentity(arg0\Field11[$04], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$04], arg0\Field3, arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            hideentity(arg0\Field11[$04])
            For local25 = $00 To $04 Step $01
                Select local25
                    Case $00
                        local12 = 875.0
                        local14 = -70.0
                        local27 = $04
                    Case $01
                        local12 = 1760.0
                        local14 = 912.0
                        local27 = $04
                    Case $02
                        local12 = 1792.0
                        local14 = -80.0
                        local27 = $04
                    Case $03
                        local12 = 890.0
                        local14 = 642.0
                        local27 = $04
                    Case $04
                        local12 = 1548.0
                        local14 = 627.0
                        local27 = $06
                End Select
                local3 = createdecal(local27, (arg0\Field3 + (local12 * (1.0 / 256.0))), (arg0\Field4 + (1.0 / 128.0)), (arg0\Field5 + (local14 * (1.0 / 256.0))), 90.0, 45.0, 0.0, ((((Float (local25 = $00)) * 0.44) + ((Float (local25 = $01)) * 1.2)) + ((Float (local25 > $01)) * 0.54)), rnd(0.8, 1.0), $00, $01, $00, $00, $00)
            Next
            local3 = createdecal($15, (arg0\Field3 - 19.77344), ((arg0\Field4 - 4.253906) + 0.05), (arg0\Field5 - 14.11719), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.5, 0.7), rnd(0.6, 1.0), $00, $01, $00, $00, $00)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 15.39062), (arg0\Field4 - 0.125), (arg0\Field5 - 4.875), 20.0, $01, (arg0\Field3 - 7.695312), (arg0\Field4 + 0.875), (arg0\Field5 - 3.625), 0.0, 90.0, 0.0)
            local2\Field8 = 270.0
            local2\Field9 = 45.0
            local7 = createitem("Class D Orientation Leaflet", $00, (arg0\Field3 - 15.36719), (arg0\Field4 + (1.0 / 1.505882)), (arg0\Field5 + (1.0 / 32.0)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $05
            local0 = createdoor(arg0, (arg0\Field3 - 5.46875), (arg0\Field4 - 0.5), (arg0\Field5 - 1.5), 0.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 0.5), arg0\Field4, (arg0\Field5 + 2.5), 90.0, $00, $00, $04, $00, $00)
            arg0\Field14[$01] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 0.375), arg0\Field4, (arg0\Field5 - 1.5), 0.0, $00, $00, $04, $00, $00)
            arg0\Field14[$02] = local0
            createdoor(arg0, (arg0\Field3 + 1.84375), arg0\Field4, (arg0\Field5 - 1.5), 0.0, $00, $00, $03, $00, $00)
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 + (1.0 / 3.2)), (arg0\Field4 + 0.75), (arg0\Field5 - (1.0 / 1.570552)), 270.0, $01)
            rotateentity(arg0\Field13[$00]\Field0, 80.0, entityyaw(arg0\Field13[$00]\Field0, $00), 0.0, $00)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 4.5), (arg0\Field4 + 3.515625), (arg0\Field5 + 0.6875), 0.0, $01, (arg0\Field3 - 6.703125), (arg0\Field4 + 0.625), (arg0\Field5 + 0.6875), 0.0, 90.0, 0.0)
            local2\Field8 = 90.0
            local2\Field9 = 0.0
            local2\Field19 = $00
            local2\Field15 = 0.0
            local2\Field22 = $01
            local2\Field21 = $01
            scalesprite(local2\Field4, 1.75, 1.75)
            camerazoom(local2\Field6, 1.5)
            hideentity(local2\Field2)
            arg0\Field16[$00] = local2
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - 6.0), (arg0\Field4 + 2.851562), (arg0\Field5 + 0.75), $00)
            rotateentity(arg0\Field11[$00], 0.0, -90.0, 0.0, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - 5.46875), arg0\Field4, (arg0\Field5 + 0.75), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            local7 = createitem("Document SCP-205", $00, (arg0\Field3 - 1.394531), (arg0\Field4 + (1.0 / 3.657143)), (arg0\Field5 + (1.0 / 1.706667)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Ballistic Helmet", $26, (arg0\Field3 + (1.0 / 1.242718)), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - (1.0 / 3.2)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 + (1.0 / 1.242718)), (arg0\Field4 + (1.0 / 1.347368)), (arg0\Field5 + 0.703125), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery((arg0\Field3 + 2.910156), (arg0\Field4 + 0.9375), (arg0\Field5 - 0.234375))
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Bloody Level 3 Key Card", $5C, (arg0\Field3 - 3.808594), (arg0\Field4 - (1.0 / 17.06667)), (arg0\Field5 + 2.539062), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, (arg0\Field3 + 0.734375), (arg0\Field5 - 2.828125))
        Case $23
            local0 = createdoor(arg0, (arg0\Field3 + 2.25), arg0\Field4, (arg0\Field5 + 0.6875), 90.0, $00, $03, $04, $00, $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + 1.898438), entityy(local0\Field3[$00], $01), (arg0\Field5 - 1.15625), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.025), $01)
            turnentity(local0\Field3[$00], 0.0, 90.0, 0.0, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + (1.0 / 2.534653)), arg0\Field4, (arg0\Field5 + 1.484375), 90.0, $01, $00, $04, $00, $00)
            local0\Field23 = $00
            local0\Field20 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 3.28125), arg0\Field4, (arg0\Field5 + 1.007812), 180.0, $00, $00, $04, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.08), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local7 = createitem("Document SCP-372", $00, (arg0\Field3 + 1.367188), (arg0\Field4 + 0.6875), (arg0\Field5 + 2.203125), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Radio Transceiver", $45, (arg0\Field3 + (1.0 / 1.376344)), (arg0\Field4 + 0.4375), (arg0\Field5 - 1.667969), $00, $00, $00, 1.0, $00)
            local7\Field12 = rnd(100.0, 0.0)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, (arg0\Field3 + 2.75), arg0\Field5)
        Case $06
            local22 = loadtexture_strict("GFX\Map\Textures\Door01_914.png", $01, $00, $01)
            local0 = createdoor(arg0, (arg0\Field3 - 4.050781), arg0\Field4, (arg0\Field5 + 2.0625), 180.0, $01, $07, $00, $00, $00)
            local0\Field4 = $01
            entitytexture(local0\Field0, local22, $00, $00)
            entitytexture(local0\Field1, local22, $00, $00)
            entitytexture(local0\Field2, local22, $00, $00)
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 1.578125), arg0\Field4, (arg0\Field5 + 2.0625), 180.0, $01, $07, $00, $00, $00)
            local0\Field4 = $01
            entitytexture(local0\Field0, local22, $00, $00)
            entitytexture(local0\Field1, local22, $00, $00)
            entitytexture(local0\Field2, local22, $00, $00)
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$01] = local0
            deletesingletextureentryfromcache(local22, $00)
            local22 = $00
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 1.4375), 0.0, $00, $03, $04, $00, $00)
            local0\Field4 = $01
            positionentity(local0\Field3[$00], (arg0\Field3 - 1.9375), entityy(local0\Field3[$00], $01), (arg0\Field5 - 1.085938), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.025), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            turnentity(local0\Field3[$00], 0.0, 90.0, 0.0, $00)
            arg0\Field14[$02] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 1.753906), arg0\Field4, (arg0\Field5 - 2.75), 90.0, $00, $00, $04, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.057), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.057), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 - 3.953125), (arg0\Field4 + 0.75), (arg0\Field5 - 3.8125), 180.0, $00)
            arg0\Field13[$01] = createlever(arg0, (arg0\Field3 - 5.078125), (arg0\Field4 + 0.75), (arg0\Field5 - 3.8125), 180.0, $00)
            arg0\Field11[$00] = loadmesh_strict("GFX\Map\Props\scp_914_key.b3d", $00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - 1.625), (arg0\Field4 + (1.0 / 1.347368)), (arg0\Field5 + 1.460938), $01)
            arg0\Field11[$01] = loadmesh_strict("GFX\Map\Props\scp_914_knob.b3d", $00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - 1.625), (arg0\Field4 + (1.0 / 1.113043)), (arg0\Field5 + 1.460938), $01)
            For local25 = $00 To $01 Step $01
                scaleentity(arg0\Field11[local25], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
                entitypickmode(arg0\Field11[local25], $02, $01)
                entityparent(arg0\Field11[local25], arg0\Field2, $01)
            Next
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 - 4.410156), (arg0\Field4 + 0.5), (arg0\Field5 + 2.480469), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 + 1.203125), (arg0\Field4 + 0.5), (arg0\Field5 + 2.5), $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = createbutton($00, (arg0\Field3 - 4.78125), (arg0\Field4 + 0.6875), (arg0\Field5 - 3.867188), 0.0, 180.0, 0.0, arg0\Field2, $01)
            arg0\Field11[$05] = loadrmesh("GFX\Map\cont1_914_blinds.rmesh", Null, $00)
            scaleentity(arg0\Field11[$05], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], (arg0\Field3 - 3.65625), (arg0\Field4 + 0.515625), (arg0\Field5 - 1.15625), $00)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            arg0\Field11[$07] = loadanimmesh_strict("GFX\Map\Props\scp_914_gears.b3d", $00)
            local24 = (1.0 / 191.0448)
            scaleentity(arg0\Field11[$07], local24, local24, local24, $00)
            positionentity(arg0\Field11[$07], (arg0\Field3 - 1.59375), (arg0\Field4 + (1.0 / 32.0)), (arg0\Field5 + 2.5), $00)
            rotateentity(arg0\Field11[$07], 0.0, 270.0, 0.0, $00)
            entityparent(arg0\Field11[$07], arg0\Field2, $01)
            local7 = createitem("Addendum: 5/14 Test Log", $00, (arg0\Field3 + 2.101562), (arg0\Field4 + (1.0 / 1.438202)), (arg0\Field5 + (1.0 / 2.015748)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            local7 = createitem("First Aid Kit", $34, (arg0\Field3 - 5.375), (arg0\Field4 + 0.4375), (arg0\Field5 - 2.679688), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            rotateentity(local7\Field2, 0.0, 270.0, 0.0, $00)
            local7 = createitem("Dr. L's Note #1", $00, (arg0\Field3 - 2.101562), (arg0\Field4 + (1.0 / 1.024)), (arg0\Field5 - 1.425781), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 2.75))
        Case $08
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field7\Field6 = $08) Then
                        arg0\Field11[$00] = copyentity(local4\Field11[$00], $00)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field11[$00] = $00) Then
                arg0\Field11[$00] = loadrmesh("GFX\Map\ventilation_fan.rmesh", Null, $00)
            EndIf
            scaleentity(arg0\Field11[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - 1.054688), (arg0\Field4 + 2.0625), arg0\Field5, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            hideentity(arg0\Field11[$00])
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 + 1.378906), (arg0\Field4 + 0.5), (arg0\Field5 - 1.0), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local7 = createitem("Empty Cup", $2C, (arg0\Field3 + 1.914062), (arg0\Field4 + 0.625), (arg0\Field5 + -0.90625), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
        Case $0A
            local0 = createdoor(arg0, (arg0\Field3 + 3.0), arg0\Field4, (arg0\Field5 - 3.232422), 90.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.1), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
        Case $0C
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 + 2.066406), 0.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - 3.898438), entityy(local0\Field3[$00], $01), arg0\Field5, $01)
            rotateentity(local0\Field3[$00], 0.0, 90.0, 0.0, $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.057), $01)
            local1 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 2.066406), 180.0, $01, $00, $00, $00, $00)
            local1\Field20 = $00
            freeentity(local1\Field3[$00])
            local1\Field3[$00] = $00
            positionentity(local1\Field3[$01], entityx(local1\Field3[$01], $01), entityy(local1\Field3[$01], $01), (entityz(local1\Field3[$01], $01) + 0.057), $01)
            local0\Field21 = local1
            local1\Field21 = local0
        Case $0D
            createdoor(arg0, (arg0\Field3 + 1.089844), arg0\Field4, (arg0\Field5 + 2.25), 90.0, $00, $04, $00, $00, $00)
            createdoor(arg0, (arg0\Field3 + 1.089844), arg0\Field4, (arg0\Field5 - 2.25), 90.0, $01, $04, $00, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 - (1.0 / 1.04918)), arg0\Field4, arg0\Field5, 90.0, $00, $00, $00, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.048), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.048), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0, (arg0\Field3 - 4.75), (arg0\Field4 - 1.5), (arg0\Field5 - 4.0), 0.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 4.75), (arg0\Field4 - 1.5), (arg0\Field5 + 4.0), 180.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 0.90625), (arg0\Field4 - 1.5), (arg0\Field5 - 2.515625), 90.0, $00, $00, $03, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 0.90625), (arg0\Field4 - 1.5), (arg0\Field5 + 2.515625), 90.0, $00, $00, $03, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local2 = createsecuritycam(arg0, (arg0\Field3 + 0.71875), (arg0\Field4 + 2.75), (arg0\Field5 + 3.71875), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 130.0
            local2\Field9 = 40.0
            local7 = createitem("Level 0 Key Card", $59, (arg0\Field3 + 2.875), (arg0\Field4 + 0.9375), (arg0\Field5 + 2.9375), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 + 2.875), (arg0\Field4 + 0.6875), (arg0\Field5 + 2.125), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery((arg0\Field3 + 2.875), (arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 - 1.75))
            entityparent(local7\Field2, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local7 = createrandombattery((arg0\Field3 + 2.851562), (arg0\Field4 + 0.6875), (arg0\Field5 - 2.265625))
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local7 = createrandombattery((arg0\Field3 + 2.890625), (arg0\Field4 + 0.9375), (arg0\Field5 - 2.929688))
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            local7 = createitem("Incident Report SCP-1048-A", $00, (arg0\Field3 + 2.875), (arg0\Field4 + 0.875), (arg0\Field5 - 1.875), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Gas Mask", $38, (arg0\Field3 - 3.5), (arg0\Field4 - 0.96875), (arg0\Field5 + 3.507812), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            If (key2_spawnrate = $03) Then
                If (rand($02, $01) <> 0) Then
                    local7 = createitem("White Key", $68, (arg0\Field3 - (1.0 / 0.4096)), (arg0\Field4 - 1.078125), (arg0\Field5 - 1.296875), $00, $00, $00, 1.0, $00)
                Else
                    local7 = createitem("White Key", $68, (arg0\Field3 - (1.0 / 0.4096)), (arg0\Field4 - 1.078125), (arg0\Field5 + 1.296875), $00, $00, $00, 1.0, $00)
                EndIf
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
        Case $0E
            local0 = createdoor(arg0, (arg0\Field3 + 1.75), arg0\Field4, arg0\Field5, -90.0, $01, $01, $00, $00, $00)
            local0\Field23 = $00
            arg0\Field14[$00] = local0
        Case $0F,$10
            local0 = createdoor(arg0, (arg0\Field3 + 1.324219), arg0\Field4, (arg0\Field5 - 1.800781), 0.0, $01, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 1.324219), arg0\Field4, (arg0\Field5 + 1.800781), 180.0, $01, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$01] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 1.789062), arg0\Field4, (arg0\Field5 + 2.875), 90.0, $00, $00, $00, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.04), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.04), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            If (arg0\Field7\Field6 = $10) Then
                arg0\Field11[$00] = createbutton($01, (arg0\Field3 - 1.847656), (arg0\Field4 + 0.6875), (arg0\Field5 - (1.0 / 1.896296)), 0.0, 270.0, 25.0, arg0\Field2, $01)
                local6 = setemitter(arg0, (arg0\Field3 + 1.023438), (arg0\Field4 + 1.28125), (arg0\Field5 - 1.613281), $01)
                local6\Field11 = $02
                If (key2_spawnrate = $02) Then
                    local7 = createitem("White Key", $68, (arg0\Field3 - 3.59375), (arg0\Field4 + 1.09375), (arg0\Field5 + (1.0 / 1.620253)), $00, $00, $00, 1.0, $00)
                    entityparent(local7\Field2, arg0\Field2, $01)
                EndIf
            Else
                local0 = createdoor(arg0, (arg0\Field3 - 1.789062), arg0\Field4, arg0\Field5, 90.0, $00, $00, $04, $00, $00)
                positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.04), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) - 1.12), $01)
                positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.04), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.07), $01)
                arg0\Field13[$00] = createlever(arg0, (arg0\Field3 + (1.0 / 1.580247)), (arg0\Field4 + 0.75), (arg0\Field5 - 1.089844), 270.0, $01)
                arg0\Field11[$00] = createpivot($00)
                positionentity(arg0\Field11[$00], (arg0\Field3 + 1.3125), (arg0\Field4 + 0.5), arg0\Field5, $00)
                entityparent(arg0\Field11[$00], arg0\Field2, $01)
                If (bk\Field0 <> 0) Then
                    local38 = ((arg0\Field3 = bk\Field1) And (arg0\Field5 = bk\Field2))
                EndIf
                If ((((bk\Field0 = $00) And (rand($02, $01) = $01)) Lor local38) <> 0) Then
                    arg0\Field11[$01] = copyentity(d_i\Field0[$00], $00)
                    scaleentity(arg0\Field11[$01], (0.796875 / meshwidth(arg0\Field11[$01])), (1.222656 / meshheight(arg0\Field11[$01])), ((1.0 / 16.0) / meshdepth(arg0\Field11[$01])), $00)
                    entitytype(arg0\Field11[$01], $01, $00)
                    positionentity(arg0\Field11[$01], (arg0\Field3 + 1.3125), arg0\Field4, (arg0\Field5 + 1.800781), $00)
                    rotateentity(arg0\Field11[$01], 0.0, 0.0, 0.0, $00)
                    entityparent(arg0\Field11[$01], arg0\Field2, $01)
                    moveentity(arg0\Field11[$01], 120.0, 0.0, 5.0)
                    bk\Field0 = $01
                    bk\Field1 = arg0\Field3
                    bk\Field2 = arg0\Field5
                    freeentity(arg0\Field14[$01]\Field1)
                    arg0\Field14[$01]\Field1 = $00
                EndIf
            EndIf
            createcustomcenter(arg0, (arg0\Field3 + 1.3125), (arg0\Field5 + 0.125))
        Case $11
            createdoor(arg0, (arg0\Field3 + 1.125), arg0\Field4, (arg0\Field5 + 2.25), 90.0, $00, $00, $02, $00, $00)
            local2 = createsecuritycam(arg0, (arg0\Field3 + 6.429688), (arg0\Field4 + 1.699219), (arg0\Field5 + (1.0 / 1.326425)), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 30.0
            local2\Field9 = 30.0
            local3 = createdecal($15, (arg0\Field3 + (1.0 / 2.485437)), (arg0\Field4 + 0.005), (arg0\Field5 + (1.0 / 1.590062)), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.7, 0.8), 1.0, $00, $01, $00, $00, $00)
            local3\Field4 = 0.00005
            local3\Field5 = 5.5
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($15, (arg0\Field3 + (1.0 / 2.485437)), ((arg0\Field4 + 2.75) - 0.005), (arg0\Field5 + (1.0 / 1.590062)), -90.0, rnd(360.0, 0.0), 0.0, rnd(0.7, 0.8), 1.0, $00, $01, $00, $00, $00)
            local3\Field4 = 0.00005
            local3\Field5 = 5.5
            entityparent(local3\Field0, arg0\Field2, $01)
            setemitter(arg0, (arg0\Field3 + (1.0 / 2.485437)), (arg0\Field4 + 2.75), (arg0\Field5 + (1.0 / 1.590062)), $16)
            setemitter(arg0, (arg0\Field3 + (1.0 / 2.485437)), (arg0\Field4 + 0.01), (arg0\Field5 + (1.0 / 1.590062)), $17)
            local7 = createitem("Level 1 Key Card", $5A, (arg0\Field3 + 6.699219), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + 2.804688), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Origami", $02, (arg0\Field3 + 5.730469), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + 3.753906), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery((arg0\Field3 + 6.695312), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + 3.65625))
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $12
            local0 = createdoor(arg0, (arg0\Field3 + 1.875), arg0\Field4, (arg0\Field5 - 2.5), 90.0, $00, $00, $05, $00, $00)
            local0\Field23 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 + 2.25), entityy(local0\Field3[$00], $01), (arg0\Field5 - 1.851562), $01)
            rotateentity(local0\Field3[$00], 0.0, 270.0, 0.0, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 2.125), (arg0\Field4 + 1.875), (arg0\Field5 + 1.0), 270.0, $00, $06, $05, $00, $00)
            local0\Field23 = $00
            arg0\Field14[$01] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 5.875), (arg0\Field4 + 1.875), (arg0\Field5 + 3.75), 180.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 - (1.0 / 5.22449)), (arg0\Field4 + 2.691406), (arg0\Field5 + 3.566406), 0.0, $01)
            local24 = (1.0 / 142.2222)
            arg0\Field21[$00] = loadanimtexture_strict("GFX\Overlays\SL_monitors_checkpoint.png", $01, $200, $200, $00, $04, $01)
            arg0\Field21[$01] = loadanimtexture_strict("GFX\Overlays\SL_monitors.png", $01, $200, $200, $00, $0B, $01)
            For local25 = $00 To $0E Step $01
                If (local25 <> $07) Then
                    arg0\Field11[local25] = copyentity(mon_i\Field0[$00], $00)
                    scaleentity(arg0\Field11[local25], local24, local24, local24, $00)
                    If (((local25 <> $04) And (local25 <> $0D)) <> 0) Then
                        local23 = createsprite($00)
                        entityfx(local23, $11)
                        spriteviewmode(local23, $02)
                        scalesprite(local23, ((meshwidth(mon_i\Field0[$00]) * local24) * 0.475), ((meshheight(mon_i\Field0[$00]) * local24) * 0.475))
                        Select local25
                            Case $00
                                entitytexture(local23, arg0\Field21[$01], $00, $00)
                            Case $01
                                entitytexture(local23, arg0\Field21[$01], $0A, $00)
                            Case $02
                                entitytexture(local23, arg0\Field21[$01], $02, $00)
                            Case $03
                                entitytexture(local23, arg0\Field21[$01], $01, $00)
                            Case $05
                                entitytexture(local23, arg0\Field21[$01], $09, $00)
                            Case $08
                                entitytexture(local23, arg0\Field21[$01], $04, $00)
                            Case $09
                                entitytexture(local23, arg0\Field21[$01], $05, $00)
                            Case $0A
                                entitytexture(local23, arg0\Field21[$01], $03, $00)
                            Case $0B
                                entitytexture(local23, arg0\Field21[$01], $08, $00)
                            Default
                                entitytexture(local23, arg0\Field21[$00], $03, $00)
                        End Select
                        entityparent(local23, arg0\Field11[local25], $01)
                    ElseIf (local25 = $04) Then
                        arg0\Field11[$12] = createsprite($00)
                        entityfx(arg0\Field11[$12], $11)
                        spriteviewmode(arg0\Field11[$12], $02)
                        scalesprite(arg0\Field11[$12], ((meshwidth(mon_i\Field0[$00]) * local24) * 0.475), ((meshheight(mon_i\Field0[$00]) * local24) * 0.475))
                        entitytexture(arg0\Field11[$12], arg0\Field21[$00], $02, $00)
                        entityparent(arg0\Field11[$12], arg0\Field11[local25], $01)
                    Else
                        arg0\Field11[$13] = createsprite($00)
                        entityfx(arg0\Field11[$13], $11)
                        spriteviewmode(arg0\Field11[$13], $02)
                        scalesprite(arg0\Field11[$13], ((meshwidth(mon_i\Field0[$00]) * local24) * 0.475), ((meshheight(mon_i\Field0[$00]) * local24) * 0.475))
                        entitytexture(arg0\Field11[$13], arg0\Field21[$01], $07, $00)
                        entityparent(arg0\Field11[$13], arg0\Field11[local25], $01)
                    EndIf
                    hideentity(arg0\Field11[local25])
                Else
                    arg0\Field11[$07] = createpivot($00)
                    positionentity(arg0\Field11[$07], arg0\Field3, (arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 - 3.125), $01)
                    entityparent(arg0\Field11[$07], arg0\Field2, $01)
                EndIf
            Next
            For local25 = $00 To $02 Step $01
                positionentity(arg0\Field11[local25], (arg0\Field3 - (1.0 / 1.231124)), (arg0\Field4 + (((112.0 * (Float local25)) + 648.0) * (1.0 / 256.0))), (arg0\Field5 - 0.234643), $00)
                rotateentity(arg0\Field11[local25], 0.0, 105.0, 0.0, $00)
                entityparent(arg0\Field11[local25], arg0\Field2, $01)
            Next
            For local25 = $03 To $05 Step $01
                positionentity(arg0\Field11[local25], (arg0\Field3 - (1.0 / 1.105884)), (arg0\Field4 + (((112.0 * (Float (local25 - $03))) + 648.0) * (1.0 / 256.0))), (arg0\Field5 + (1.0 / 2.673788)), $00)
                rotateentity(arg0\Field11[local25], 0.0, 90.0, 0.0, $00)
                entityparent(arg0\Field11[local25], arg0\Field2, $01)
            Next
            For local25 = $06 To $08 Step $02
                positionentity(arg0\Field11[local25], (arg0\Field3 - (1.0 / 1.105884)), (arg0\Field4 + (((112.0 * (Float (local25 - $06))) + 648.0) * (1.0 / 256.0))), (arg0\Field5 + 0.999), $00)
                rotateentity(arg0\Field11[local25], 0.0, 90.0, 0.0, $00)
                entityparent(arg0\Field11[local25], arg0\Field2, $01)
            Next
            For local25 = $09 To $0B Step $01
                positionentity(arg0\Field11[local25], (arg0\Field3 - (1.0 / 1.105884)), (arg0\Field4 + (((112.0 * (Float (local25 - $09))) + 648.0) * (1.0 / 256.0))), (arg0\Field5 + 1.624), $00)
                rotateentity(arg0\Field11[local25], 0.0, 90.0, 0.0, $00)
                entityparent(arg0\Field11[local25], arg0\Field2, $01)
            Next
            For local25 = $0C To $0E Step $01
                positionentity(arg0\Field11[local25], (arg0\Field3 - (1.0 / 1.229953)), (arg0\Field4 + (((112.0 * (Float (local25 - $0C))) + 648.0) * (1.0 / 256.0))), (arg0\Field5 + 2.232746), $00)
                rotateentity(arg0\Field11[local25], 0.0, 75.0, 0.0, $00)
                entityparent(arg0\Field11[local25], arg0\Field2, $01)
            Next
            arg0\Field11[$0F] = createpivot($00)
            positionentity(arg0\Field11[$0F], (arg0\Field3 + 2.734375), (arg0\Field4 + 2.734375), (arg0\Field5 + 1.0), $00)
            entityparent(arg0\Field11[$0F], arg0\Field2, $01)
            arg0\Field11[$10] = createpivot($00)
            positionentity(arg0\Field11[$10], (arg0\Field3 - 0.234375), (arg0\Field4 + 2.734375), (arg0\Field5 + (1.0 / 1.28)), $00)
            entityparent(arg0\Field11[$10], arg0\Field2, $01)
            arg0\Field11[$11] = createpivot($00)
            positionentity(arg0\Field11[$11], (arg0\Field3 - 0.1875), (arg0\Field4 + 2.109375), (arg0\Field5 + 2.5625), $00)
            entityparent(arg0\Field11[$11], arg0\Field2, $01)
            arg0\Field11[$14] = createredlight((arg0\Field3 + 3.744141), (arg0\Field4 + 2.978516), (arg0\Field5 + 2.613281))
            arg0\Field12[$14] = $01
            entityparent(arg0\Field11[$14], arg0\Field2, $01)
            hideentity(arg0\Field11[$14])
            local2 = createsecuritycam(arg0, (arg0\Field3 - (1.0 / 1.610063)), (arg0\Field4 + 1.5), (arg0\Field5 - 3.628906), 20.0, $01, (arg0\Field3 - (1.0 / 1.108225)), (arg0\Field4 + 2.96875), (arg0\Field5 + 1.0), 0.0, 90.0, 0.0)
            local2\Field8 = 315.0
        Case $13
            local0 = createdoor(arg0, (arg0\Field3 - 5.03125), arg0\Field4, arg0\Field5, 270.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field16 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            moveentity(local0\Field3[$01], 0.0, 0.0, -8.0)
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 2.96875), arg0\Field4, arg0\Field5, 270.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field23 = $00
            local0\Field16 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            moveentity(local0\Field3[$01], 0.0, 0.0, -8.0)
            arg0\Field14[$01] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 1.03125), arg0\Field4, arg0\Field5, 270.0, $00, $00, $00, $00, $00)
            moveentity(local0\Field3[$00], 0.0, 0.0, -8.0)
            moveentity(local0\Field3[$01], 0.0, 0.0, -8.0)
            local0\Field20 = $00
            arg0\Field14[$02] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 1.03125), arg0\Field4, arg0\Field5, 270.0, $00, $00, $00, $00, $00)
            moveentity(local0\Field3[$00], 0.0, 0.0, -8.0)
            moveentity(local0\Field3[$01], 0.0, 0.0, -8.0)
            local0\Field20 = $00
            arg0\Field14[$03] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 2.96875), arg0\Field4, arg0\Field5, 90.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field23 = $00
            local0\Field16 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            moveentity(local0\Field3[$01], 0.0, 0.0, -8.0)
            arg0\Field14[$04] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 5.03125), arg0\Field4, arg0\Field5, 90.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field16 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            moveentity(local0\Field3[$01], 0.0, 0.0, -8.0)
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field14[$05] = local0
            arg0\Field11[$00] = loadrmesh("GFX\Map\room2_storage_fake_hall.rmesh", Null, $01)
            scaleentity(arg0\Field11[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - 4.0), arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            hideentity(arg0\Field11[$00])
            arg0\Field11[$01] = copyentity(arg0\Field11[$00], $00)
            scaleentity(arg0\Field11[$01], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$01], (arg0\Field3 + 4.0), arg0\Field4, arg0\Field5, $00)
            rotateentity(arg0\Field11[$01], 0.0, 180.0, 0.0, $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            hideentity(arg0\Field11[$01])
            arg0\Field11[$02] = loadrmesh("GFX\Map\room2_storage_posters.rmesh", Null, $00)
            scaleentity(arg0\Field11[$02], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$02], arg0\Field3, arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            hideentity(arg0\Field11[$02])
            local7 = createitem("Document SCP-939", $00, (arg0\Field3 + 1.375), (arg0\Field4 + 0.6875), (arg0\Field5 + 1.0), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 4.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery((arg0\Field3 + 1.375), (arg0\Field4 + 0.4375), (arg0\Field5 + 1.75))
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Empty Cup", $2C, (arg0\Field3 - 2.625), (arg0\Field4 + 0.9375), (arg0\Field5 + 1.125), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Level 0 Key Card", $59, (arg0\Field3 - 2.625), (arg0\Field4 + 0.9375), (arg0\Field5 + 0.875), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $14,$37,$5C
            local0 = createdoor(arg0, (arg0\Field3 - 1.125), arg0\Field4, (arg0\Field5 + 2.25), 90.0, $00, $00, $06, $00, $00)
            arg0\Field14[$00] = local0
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 - 1.433594), (arg0\Field4 + 0.75), (arg0\Field5 - 0.828125), -90.0, $01)
            arg0\Field13[$01] = createlever(arg0, (arg0\Field3 - 1.433594), (arg0\Field4 + 0.75), (arg0\Field5 - 0.515625), -90.0, $01)
            local2 = createsecuritycam(arg0, arg0\Field3, (arg0\Field4 + 2.75), (arg0\Field5 - 3.722656), 30.0, $01, (arg0\Field3 - 1.523438), (arg0\Field4 + 0.796875), (arg0\Field5 + (1.0 / 7.529412)), 0.0, -90.0, 0.0)
            local2\Field9 = 0.0
            arg0\Field11[$00] = createsprite($00)
            arg0\Field12[$00] = $01
            entitytexture(arg0\Field11[$00], t\Field2[$03], $00, $00)
            spriteviewmode(arg0\Field11[$00], $02)
            entityblend(arg0\Field11[$00], $03)
            entityfx(arg0\Field11[$00], $19)
            positionentity(arg0\Field11[$00], arg0\Field3, (arg0\Field4 + 0.8), arg0\Field5, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            hideentity(arg0\Field11[$00])
            arg0\Field11[$01] = createredlight((arg0\Field3 - 0.125), (arg0\Field4 + 2.21875), arg0\Field5)
            arg0\Field12[$01] = $01
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            hideentity(arg0\Field11[$01])
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If ((((local4\Field7\Field6 = $14) Lor (local4\Field7\Field6 = $37)) Lor (local4\Field7\Field6 = $5C)) <> 0) Then
                        arg0\Field11[$02] = copyentity(local4\Field11[$02], $00)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field11[$02] = $00) Then
                arg0\Field11[$02] = loadrmesh("GFX\Map\room2_tesla_lcz_blinds.rmesh", Null, $00)
            EndIf
            scaleentity(arg0\Field11[$02], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            hideentity(arg0\Field11[$02])
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 - 1.273438), (arg0\Field4 + 0.515625), (arg0\Field5 - 2.25), $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 1.0))
        Case $15
            local0 = createdoor(arg0, (arg0\Field3 - 1.0), arg0\Field4, (arg0\Field5 + 2.5), 90.0, $00, $00, $03, $00, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 4.0), arg0\Field4, (arg0\Field5 + 2.5), 270.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            createdoor(arg0, (arg0\Field3 - 2.0), arg0\Field4, (arg0\Field5 + 1.46875), 0.0, $00, $00, $00, $00, $00)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - 2.5), (arg0\Field4 + 0.5), (arg0\Field5 - 3.5625), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - 2.613281), (arg0\Field4 + 0.5), (arg0\Field5 - (1.0 / 16.0)), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createsprite($00)
            arg0\Field12[$02] = $01
            local22 = loadtexture_strict("GFX\Map\Textures\glass.png", $03, $00, $00)
            textureblend(local22, $02)
            entitytexture(arg0\Field11[$02], local22, $00, $00)
            deletesingletextureentryfromcache(local22, $00)
            local22 = $00
            spriteviewmode(arg0\Field11[$02], $02)
            scalesprite(arg0\Field11[$02], (1.0 / 2.813187), (1.0 / 2.694737))
            positionentity(arg0\Field11[$02], (arg0\Field3 - 2.5), (arg0\Field4 + 0.875), (arg0\Field5 - 0.8125), $00)
            turnentity(arg0\Field11[$02], 0.0, 180.0, 0.0, $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            hideentity(arg0\Field11[$02])
            local7 = createitem("S-NAV Navigator", $49, (arg0\Field3 - 1.796875), (arg0\Field4 + (1.0 / 1.219048)), (arg0\Field5 - (1.0 / 2.37037)), $00, $00, $00, 1.0, $00)
            local7\Field12 = rnd(100.0, 0.0)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Level 2 Key Card", $5B, (arg0\Field3 - 3.667969), (arg0\Field4 + (1.0 / 1.868613)), (arg0\Field5 + 0.453125), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 180.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $16
            createdoor(arg0, (arg0\Field3 + 1.0), arg0\Field4, (arg0\Field5 + 2.625), 270.0, $00, $00, $05, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 - 2.0), (arg0\Field4 - 3.0), (arg0\Field5 - 1.25), 0.0, $00, $00, $00, $00, $00)
            local0\Field23 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 + 0.6875), (arg0\Field4 - 2.195312), (arg0\Field5 - 1.382812), $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field14[$00] = local0
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 + 0.9375), (arg0\Field4 - 2.28125), (arg0\Field5 - 1.433594), 0.0, $00)
            arg0\Field11[$00] = loadrmesh("GFX\Map\cont2_012_box.rmesh", Null, $00)
            scaleentity(arg0\Field11[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - 1.40625), (arg0\Field4 - (1.0 / 1.969231)), (arg0\Field5 + 1.78125), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            hideentity(arg0\Field11[$00])
            arg0\Field11[$01] = createredlight((arg0\Field3 - (1.0 / 5.885057)), (arg0\Field4 - 2.242188), (arg0\Field5 - 1.414062))
            arg0\Field12[$01] = $01
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            hideentity(arg0\Field11[$01])
            arg0\Field11[$02] = loadrmesh("GFX\Map\ventilation_fan.rmesh", Null, $00)
            scaleentity(arg0\Field11[$02], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$02], (arg0\Field3 - 1.757812), (arg0\Field4 + 2.0625), (arg0\Field5 - 1.492188), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            hideentity(arg0\Field11[$02])
            arg0\Field11[$03] = loadmesh_strict("GFX\Map\Props\scp_012.b3d", $00)
            scaleentity(arg0\Field11[$03], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$03], (arg0\Field3 - 1.40625), (arg0\Field4 - 0.703125), (arg0\Field5 + 1.78125), $00)
            entityparent(arg0\Field11[$03], arg0\Field11[$00], $01)
            local7 = createitem("White Severed Hand", $64, (arg0\Field3 - 3.0625), ((arg0\Field4 - 2.25) + 0.3), (arg0\Field5 + 2.5), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-012", $00, (arg0\Field3 - 0.21875), (arg0\Field4 - 2.25), (arg0\Field5 - 1.59375), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local3 = createdecal($03, (arg0\Field3 - 3.0625), ((arg0\Field4 - 3.0) + 0.01), (arg0\Field5 + 2.5), 90.0, rnd(360.0, 0.0), 0.0, 0.5, 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
        Case $17
            local0 = createdoor(arg0, (arg0\Field3 + 1.0625), arg0\Field4, arg0\Field5, 90.0, $00, $00, $05, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0, (arg0\Field3 - 1.0625), arg0\Field4, arg0\Field5, 270.0, $01, $00, $05, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            createdoor(arg0, (arg0\Field3 - 2.1875), arg0\Field4, (arg0\Field5 - 1.0625), 0.0, $00, $00, $05, $00, $00)
            createdoor(arg0, (arg0\Field3 - 2.1875), arg0\Field4, (arg0\Field5 + 1.0625), 0.0, $01, $00, $05, $00, $00)
            createdoor(arg0, (arg0\Field3 + 2.1875), arg0\Field4, (arg0\Field5 - 1.0625), 180.0, $00, $00, $05, $00, $00)
            createdoor(arg0, (arg0\Field3 + 2.1875), arg0\Field4, (arg0\Field5 + 1.0625), 180.0, $00, $00, $05, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 - 3.1875), arg0\Field4, arg0\Field5, 270.0, $00, $00, $05, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 + 3.1875), arg0\Field4, arg0\Field5, 90.0, $00, $00, $05, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            For local25 = $00 To $03 Step $01
                Select local25
                    Case $00
                        local12 = 560.0
                        local14 = -416.0
                    Case $01
                        local12 = -560.0
                        local14 = -416.0
                    Case $02
                        local12 = 560.0
                        local14 = 416.0
                    Case $03
                        local12 = -560.0
                        local14 = 416.0
                End Select
                local2 = createsecuritycam(arg0, (arg0\Field3 + (local12 * (1.0 / 256.0))), (arg0\Field4 + 1.507812), (arg0\Field5 + (local14 * (1.0 / 256.0))), 30.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
                If (local25 < $02) Then
                    local2\Field8 = 180.0
                Else
                    local2\Field8 = 0.0
                EndIf
                local2\Field9 = 30.0
            Next
            For local25 = $00 To $0E Step $01
                Select local25
                    Case $00
                        local12 = -64.0
                        local14 = -516.0
                    Case $01
                        local12 = -96.0
                        local14 = -388.0
                    Case $02
                        local12 = -128.0
                        local14 = -292.0
                    Case $03
                        local12 = -128.0
                        local14 = -132.0
                    Case $04
                        local12 = -160.0
                        local14 = -36.0
                    Case $05
                        local12 = -192.0
                        local14 = 28.0
                    Case $06
                        local12 = -384.0
                        local14 = 28.0
                    Case $07
                        local12 = -448.0
                        local14 = 92.0
                    Case $08
                        local12 = -480.0
                        local14 = 124.0
                    Case $09
                        local12 = -512.0
                        local14 = 156.0
                    Case $0A
                        local12 = -544.0
                        local14 = 220.0
                    Case $0B
                        local12 = -544.0
                        local14 = 380.0
                    Case $0C
                        local12 = -544.0
                        local14 = 476.0
                    Case $0D
                        local12 = -544.0
                        local14 = 572.0
                    Case $0E
                        local12 = -544.0
                        local14 = 636.0
                End Select
                local3 = createdecal(rand($10, $11), (arg0\Field3 + (local12 * (1.0 / 256.0))), (arg0\Field4 + 0.005), (arg0\Field5 + (local14 * (1.0 / 256.0))), 90.0, rnd(360.0, 0.0), 0.0, ((rnd(0.2, 0.25) * (Float (local25 <= $0A))) + (rnd(0.1, 0.17) * (Float (local25 > $0A)))), 1.0, $00, $01, $00, $00, $00)
                entityparent(local3\Field0, arg0\Field2, $01)
            Next
            local7 = createitem("SCP-714", $1B, (arg0\Field3 - 2.1875), (arg0\Field4 + (1.0 / 1.383784)), (arg0\Field5 - 2.96875), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("SCP-1025", $20, (arg0\Field3 + 2.1875), (arg0\Field4 + (1.0 / 1.383784)), (arg0\Field5 - 2.96875), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("SCP-860", $1E, (arg0\Field3 + 2.1875), (arg0\Field4 + (1.0 / 1.383784)), (arg0\Field5 + 2.988281), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-427", $00, (arg0\Field3 - 2.375), (arg0\Field4 + 0.125), (arg0\Field5 + 2.484375), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-714", $00, (arg0\Field3 - 2.84375), (arg0\Field4 + 1.132812), (arg0\Field5 - 1.40625), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-860", $00, (arg0\Field3 + 2.84375), (arg0\Field4 + 1.132812), (arg0\Field5 + 1.40625), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $18
            local0 = createdoor(arg0, (arg0\Field3 + 1.125), arg0\Field4, (arg0\Field5 + 2.25), 90.0, $00, $00, $06, $00, $00)
            local0\Field4 = $01
            arg0\Field14[$00] = local0
            createdoor(arg0, (arg0\Field3 + 3.0625), arg0\Field4, (arg0\Field5 + 2.625), 90.0, $00, $00, $06, $00, $00)
            createdoor(arg0, (arg0\Field3 + 2.171875), arg0\Field4, (arg0\Field5 + 1.125), 0.0, $00, $00, $06, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 - 4.0), arg0\Field4, (arg0\Field5 - (1.0 / 0.64)), 270.0, $00, $00, $04, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 2.25), (arg0\Field4 + 0.625), (arg0\Field5 + 2.46875), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            For local25 = $00 To $01 Step $01
                Select local25
                    Case $00
                        local12 = 850.0
                        local13 = 385.0
                        local14 = 876.0
                    Case $01
                        local12 = 616.0
                        local13 = 512.0
                        local14 = 150.0
                End Select
                local2 = createsecuritycam(arg0, (arg0\Field3 + (local12 * (1.0 / 256.0))), (arg0\Field4 + (local13 * (1.0 / 256.0))), (arg0\Field5 + (local14 * (1.0 / 256.0))), 30.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
                local2\Field8 = (220.0 - ((Float local25) * 40.0))
                local2\Field9 = 30.0
            Next
            local7 = createitem("Syringe", $55, (arg0\Field3 - 2.847656), (arg0\Field4 + 0.53125), (arg0\Field5 + 2.921875), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-914", $00, (arg0\Field3 - 2.617188), (arg0\Field4 + 0.53125), (arg0\Field5 - 2.898438), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("SCP-1499", $24, (arg0\Field3 + 2.40625), (arg0\Field4 + 0.6875), (arg0\Field5 - (1.0 / 1.094017)), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-1499", $00, (arg0\Field3 + 3.269531), (arg0\Field4 + 1.015625), (arg0\Field5 + (1.0 / 1.21327)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Emily Ross' Badge", $03, (arg0\Field3 + 1.421875), (arg0\Field4 + (1.0 / 51.2)), (arg0\Field5 + 2.796875), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-500", $00, (arg0\Field3 + 3.480469), (arg0\Field4 + 0.890625), (arg0\Field5 + 1.894531), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            rotateentity(local7\Field2, 0.0, 90.0, 0.0, $00)
            If (rand($04, $01) = $01) Then
                local7 = createitem("SCP-500", $15, (arg0\Field3 + 4.480469), (arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 + 1.347656), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
        Case $19
            local0 = createdoor(arg0, (arg0\Field3 + 1.375), (arg0\Field4 + 3.003906), (arg0\Field5 - 2.5), 90.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field16 = $01
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 1.3125), (arg0\Field4 + 3.003906), (arg0\Field5 + 2.78125), 90.0, $00, $05, $00, $00, $00)
            local0\Field38 = $01
            local0\Field4 = $02
            local0\Field23 = $00
            arg0\Field14[$01] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 1.3125), (arg0\Field4 + 3.003906), (arg0\Field5 + 0.65625), 270.0, $00, $05, $00, $00, $00)
            local0\Field38 = $01
            arg0\Field14[$02] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 2.609375), (arg0\Field4 + 3.003906), (arg0\Field5 - 2.75), 0.0, $00, $05, $00, $00, $00)
            local0\Field38 = $01
            arg0\Field14[$03] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 3.5625), arg0\Field4, (arg0\Field5 + 1.40625), 0.0, $00, $06, $04, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.06), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.031), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.12), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.031), $01)
            createdoor(arg0, (arg0\Field3 + 1.375), arg0\Field4, (arg0\Field5 - 2.5), 90.0, $00, $00, $00, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 + 3.5625), (arg0\Field4 + 3.003906), (arg0\Field5 + 1.40625), 0.0, $01, $06, $04, $00, $00)
            local0\Field4 = $01
            local0\Field20 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.06), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.031), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.12), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.031), $01)
            local0 = createdoor(arg0, arg0\Field3, (arg0\Field4 + 3.003906), (arg0\Field5 + 1.625), 0.0, $00, $05, $00, $00, $00)
            local0\Field38 = $01
            local0\Field4 = $02
            local0\Field23 = $00
            local0 = createdoor(arg0, arg0\Field3, (arg0\Field4 + 3.003906), (arg0\Field5 - 3.691406), 0.0, $00, $05, $00, $00, $00)
            local0\Field38 = $01
            local0\Field4 = $02
            local0\Field23 = $00
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 3.5625), (arg0\Field4 + (1.0 / 1.505882)), (arg0\Field5 + 3.347656), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - (1.0 / 1.841727)), (arg0\Field4 + 3.554688), (arg0\Field5 + 2.558594), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 - 3.195312), (arg0\Field4 + 3.320312), (arg0\Field5 + 2.875), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 + 3.234375), (arg0\Field4 + 3.320312), (arg0\Field5 + 2.3125), $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], (arg0\Field3 - 2.757812), (arg0\Field4 + 3.554688), (arg0\Field5 - 3.300781), $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            arg0\Field11[$05] = createpivot($00)
            positionentity(arg0\Field11[$05], (arg0\Field3 - 2.246094), (arg0\Field4 + 3.554688), (arg0\Field5 - 1.570312), $00)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], (arg0\Field3 - 1.828125), (arg0\Field4 + 3.320312), (arg0\Field5 - 1.066406), $00)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            arg0\Field11[$07] = loadrmesh("GFX\Map\cont2_1123_cell.rmesh", Null, $01)
            scaleentity(arg0\Field11[$07], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$07], arg0\Field3, arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field11[$07], arg0\Field2, $01)
            hideentity(arg0\Field11[$07])
            local3 = createdecal($06, (arg0\Field3 - 2.148438), ((arg0\Field4 + 3.003906) + 0.005), (arg0\Field5 + 2.21875), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.4, 0.5), rnd(0.8, 1.0), $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($04, (arg0\Field3 + 0.703125), ((arg0\Field4 + 3.003906) + 0.005), (arg0\Field5 + 3.113281), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.6, 0.7), rnd(0.8, 1.0), $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local7 = createitem("Document SCP-1123", $00, (arg0\Field3 + 2.117188), (arg0\Field4 + (1.0 / 2.048)), (arg0\Field5 - 3.65625), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Gas Mask", $38, (arg0\Field3 + 2.378906), (arg0\Field4 + (1.0 / 1.706667)), (arg0\Field5 + 3.753906), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("SCP-1123", $23, (arg0\Field3 + 3.5625), (arg0\Field4 + (1.0 / 1.505882)), (arg0\Field5 + 3.347656), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 90.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Leaflet", $00, (arg0\Field3 - 2.953125), (arg0\Field4 + 3.59375), (arg0\Field5 + 2.035156), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $1B
            local0 = createdoor(arg0, (arg0\Field3 + 1.0), arg0\Field4, (arg0\Field5 - 2.25), 90.0, $00, $00, $05, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.165), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
        Case $1C
            local0 = createdoor(arg0, (arg0\Field3 + 3.183594), arg0\Field4, (arg0\Field5 - 1.375), 180.0, $00, $06, $FFFFFFFD, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.07), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.07), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0, (arg0\Field3 + 1.375), arg0\Field4, (arg0\Field5 - 3.183594), 90.0, $00, $06, $FFFFFFFD, $00, $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) - 0.07), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.07), $01)
            local0 = createdoor(arg0, (arg0\Field3 - 2.875), arg0\Field4, (arg0\Field5 - (1.0 / 3.2)), 0.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field12 = $15E
            positionentity(local0\Field3[$00], (arg0\Field3 - 1.125), entityy(local0\Field3[$00], $01), (arg0\Field5 - 2.46875), $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + (1.0 / 3.2)), arg0\Field4, (arg0\Field5 + 2.875), 270.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field12 = $15E
            positionentity(local0\Field3[$00], (arg0\Field3 + 2.46875), entityy(local0\Field3[$00], $01), (arg0\Field5 + 1.125), $01)
            rotateentity(local0\Field3[$00], 0.0, 90.0, 0.0, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field14[$01] = local0
            arg0\Field14[$00]\Field21 = arg0\Field14[$01]
            arg0\Field14[$01]\Field21 = arg0\Field14[$00]
            local2 = createsecuritycam(arg0, (arg0\Field3 - 2.6875), (arg0\Field4 + 1.5), (arg0\Field5 + 2.6875), 40.0, $01, (arg0\Field3 + 2.617188), (arg0\Field4 + 1.09375), (arg0\Field5 - 0.375), 0.0, 90.0, 0.0)
            local2\Field8 = 225.0
            local2\Field9 = 45.0
            local2 = createsecuritycam(arg0, (arg0\Field3 - 0.4375), (arg0\Field4 + 1.5), (arg0\Field5 + 0.4375), 40.0, $01, (arg0\Field3 + 0.375), (arg0\Field4 + 1.09375), (arg0\Field5 - 2.617188), 0.0, 0.0, 0.0)
            local2\Field8 = 45.0
            local2\Field9 = 45.0
            local6 = setemitter(arg0, (arg0\Field3 - (1.0 / 1.462857)), (arg0\Field4 + 1.328125), (arg0\Field5 + 2.558594), $00)
            local6\Field11 = $01
            local6 = setemitter(arg0, (arg0\Field3 - 2.558594), (arg0\Field4 + 1.328125), (arg0\Field5 + 0.9375), $00)
            local6\Field11 = $01
            createcustomcenter(arg0, (arg0\Field3 - 2.875), (arg0\Field5 - 1.375))
        Case $1D
            local0 = createdoor(arg0, (arg0\Field3 + 3.183594), arg0\Field4, (arg0\Field5 - 1.375), 180.0, $01, $06, $FFFFFFFD, $00, $00)
            local0\Field23 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.07), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.07), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0, (arg0\Field3 + 1.375), arg0\Field4, (arg0\Field5 - 3.183594), 90.0, $01, $06, $FFFFFFFD, $00, $00)
            local0\Field23 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) - 0.07), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.07), $01)
            local0 = createdoor(arg0, (arg0\Field3 - 2.875), arg0\Field4, (arg0\Field5 - (1.0 / 3.2)), 0.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            positionentity(local0\Field3[$00], (arg0\Field3 - 1.125), entityy(local0\Field3[$00], $01), (arg0\Field5 - 2.46875), $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0 = createdoor(arg0, (arg0\Field3 + (1.0 / 3.2)), arg0\Field4, (arg0\Field5 + 2.875), 270.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            positionentity(local0\Field3[$00], (arg0\Field3 + 2.46875), entityy(local0\Field3[$00], $01), (arg0\Field5 + 1.125), $01)
            rotateentity(local0\Field3[$00], 0.0, 90.0, 0.0, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            createcustomcenter(arg0, (arg0\Field3 + 3.183594), (arg0\Field5 - 3.183594))
        Case $1E
            local0 = createdoor(arg0, (arg0\Field3 + 0.96875), arg0\Field4, (arg0\Field5 - 2.875), 90.0, $00, $00, $04, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.031), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.031), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 + 1.125), 0.0, $01, $00, $05, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.132), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            local0 = createdoor(arg0, (arg0\Field3 - 2.375), arg0\Field4, (arg0\Field5 + 1.125), 0.0, $01, $00, $05, $00, $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) - 0.032), $01)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 3.925781), (arg0\Field4 + 0.5), (arg0\Field5 - 2.4375), $00)
            entityradius(arg0\Field11[$00], 0.1, 0.0)
            entitypickmode(arg0\Field11[$00], $01, $01)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 0.75), (arg0\Field4 + 2.75), (arg0\Field5 + 0.75), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 225.0
            local2\Field9 = 45.0
            local7 = createitem("Document SCP-1162-ARC", $00, (arg0\Field3 + 2.938387), (arg0\Field4 + 0.59375), (arg0\Field5 - 1.167969), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-066", $00, (arg0\Field3 + 1.328125), (arg0\Field4 + 0.59375), (arg0\Field5 - (1.0 / 1.089362)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            rotateentity(local7\Field2, 0.0, 240.0, 0.0, $00)
            local7 = createitem("Incident Report SCP-066-2", $00, (arg0\Field3 - (1.0 / 12.19048)), (arg0\Field4 + 0.875), (arg0\Field5 + 3.230469), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("S-NAV Navigator", $49, (arg0\Field3 - (1.0 / 1.062241)), (arg0\Field4 + 0.59375), (arg0\Field5 + 3.148438), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Gas Mask", $38, (arg0\Field3 + 2.304688), (arg0\Field4 + (1.0 / 5.12)), (arg0\Field5 - 1.222656), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            rotateentity(local7\Field2, 0.0, 30.0, 0.0, $00)
            local7 = createrandombattery((arg0\Field3 + 2.546875), (arg0\Field4 + (1.0 / 5.12)), (arg0\Field5 - 1.328125))
            entityparent(local7\Field2, arg0\Field2, $01)
            If (key2_spawnrate = $04) Then
                local7 = createitem("White Key", $68, (arg0\Field3 + 2.082031), (arg0\Field4 + (1.0 / 1.706667)), (arg0\Field5 + 1.460938), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
        Case $1F
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 + 1.75), 0.0, $01, $01, $00, $00, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 22.8125), (arg0\Field4 - 22.0), (arg0\Field5 + 4.0625), 0.0, $00, $01, $00, $00, $00)
            arg0\Field14[$01] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 2.375), arg0\Field4, (arg0\Field5 - 1.195312), 180.0, $01, $01, $00, $00, $00)
            arg0\Field14[$02] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 1.78125), (arg0\Field4 - 22.0), (arg0\Field5 - 3.1875), 180.0, $00, $01, $00, $00, $00)
            arg0\Field14[$03] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 0.21875), (arg0\Field4 - 22.0), (arg0\Field5 + 24.60938), 90.0, $00, $02, $00, $00, $00)
            local0\Field20 = $00
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$04] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 4.230469), (arg0\Field4 - 22.0), (arg0\Field5 + 2.578125), 0.0, $00, $02, $00, $00, $00)
            local0\Field20 = $00
            local0\Field4 = $01
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            local0 = createdoor(arg0, (arg0\Field3 + 13.46094), (arg0\Field4 - 22.0), (arg0\Field5 + 24.60938), 90.0, $00, $02, $00, $00, $00)
            local0\Field20 = $00
            local0\Field4 = $01
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            createdoor(arg0, (arg0\Field3 + 1.0), arg0\Field4, arg0\Field5, 90.0, $00, $00, $FFFFFFFF, $00, $00)
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 + 12.09375), (arg0\Field4 - 21.34375), (arg0\Field5 + 25.66016), 0.0, $00)
            arg0\Field13[$01] = createlever(arg0, (arg0\Field3 + 4.75), (arg0\Field4 - 21.34375), (arg0\Field5 + 12.65625), 0.0, $00)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], arg0\Field3, (arg0\Field4 + 0.9375), (arg0\Field5 + 2.9375), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 + 22.8125), (arg0\Field4 - 21.0625), (arg0\Field5 + 5.25), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 + 2.375), (arg0\Field4 + 0.9375), (arg0\Field5 - 2.382812), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 - 1.78125), (arg0\Field4 - 21.0625), (arg0\Field5 - 4.375), $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], (arg0\Field3 + 8.417969), (arg0\Field4 - 21.67969), (arg0\Field5 + 7.679688), $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            arg0\Field11[$05] = createpivot($00)
            positionentity(arg0\Field11[$05], (arg0\Field3 + 8.417969), (arg0\Field4 - 21.67969), (arg0\Field5 - 3.78125), $00)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], (arg0\Field3 + 15.54688), (arg0\Field4 - 21.67969), (arg0\Field5 - 3.78125), $00)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            arg0\Field11[$07] = createpivot($00)
            positionentity(arg0\Field11[$07], (arg0\Field3 + 15.54688), (arg0\Field4 - 21.67969), (arg0\Field5 + 7.679688), $00)
            entityparent(arg0\Field11[$07], arg0\Field2, $01)
            arg0\Field11[$08] = createpivot($00)
            positionentity(arg0\Field11[$08], (arg0\Field3 + 2.214844), (arg0\Field4 - 21.67969), (arg0\Field5 + 20.21875), $00)
            entityparent(arg0\Field11[$08], arg0\Field2, $01)
            arg0\Field11[$09] = createpivot($00)
            positionentity(arg0\Field11[$09], (arg0\Field3 + 2.214844), (arg0\Field4 - 21.67969), (arg0\Field5 + 24.89453), $00)
            entityparent(arg0\Field11[$09], arg0\Field2, $01)
            arg0\Field11[$0A] = createpivot($00)
            positionentity(arg0\Field11[$0A], (arg0\Field3 + 11.48438), (arg0\Field4 - 21.67969), (arg0\Field5 + 24.89453), $00)
            entityparent(arg0\Field11[$0A], arg0\Field2, $01)
            arg0\Field11[$0B] = createpivot($00)
            positionentity(arg0\Field11[$0B], (arg0\Field3 + 11.48438), (arg0\Field4 - 21.67969), (arg0\Field5 + 20.21875), $00)
            entityparent(arg0\Field11[$0B], arg0\Field2, $01)
            arg0\Field11[$0C] = createpivot($00)
            positionentity(arg0\Field11[$0C], (arg0\Field3 + 4.230469), (arg0\Field4 - 21.67969), (arg0\Field5 + 11.80859), $00)
            entityparent(arg0\Field11[$0C], arg0\Field2, $01)
            arg0\Field11[$0D] = createpivot($00)
            positionentity(arg0\Field11[$0D], (arg0\Field3 + 4.230469), (arg0\Field4 - 21.67969), (arg0\Field5 + 4.609375), $00)
            entityparent(arg0\Field11[$0D], arg0\Field2, $01)
            arg0\Field11[$0E] = createpivot($00)
            positionentity(arg0\Field11[$0E], (arg0\Field3 - 1.78125), (arg0\Field4 - 21.67969), (arg0\Field5 + 4.609375), $00)
            entityparent(arg0\Field11[$0E], arg0\Field2, $01)
            arg0\Field11[$0F] = createpivot($00)
            positionentity(arg0\Field11[$0F], (arg0\Field3 - 1.78125), (arg0\Field4 - 21.67969), (arg0\Field5 + 11.80859), $00)
            entityparent(arg0\Field11[$0F], arg0\Field2, $01)
            local6 = setemitter(arg0, (arg0\Field3 + 20.48828), (arg0\Field4 - 21.8125), (arg0\Field5 - 2.246094), $06)
            local6\Field11 = $01
            Select rand($03, $01)
                Case $01
                    local12 = 4674.0
                    local14 = 950.0
                Case $02
                    local12 = 3032.0
                    local14 = 1288.0
                Case $03
                    local12 = 2938.0
                    local14 = 2793.0
            End Select
            local7 = createitem("Black Severed Hand", $65, (arg0\Field3 + (local12 * (1.0 / 256.0))), (arg0\Field4 - 21.46875), (arg0\Field5 + (local14 * (1.0 / 256.0))), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Bloody Level 1 Key Card", $5A, (arg0\Field3 + 13.16406), (arg0\Field4 - 21.46875), (arg0\Field5 + 24.22266), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Night Vision Goggles", $40, (arg0\Field3 + 4.875), (arg0\Field4 - 21.46875), (arg0\Field5 + 3.832031), $00, $00, $00, 1.0, $00)
            local7\Field12 = rnd(0.0, 1000.0)
            entityparent(local7\Field2, arg0\Field2, $01)
            local3 = createdecal($03, (arg0\Field3 + (local12 * (1.0 / 256.0))), ((arg0\Field4 - 22.0) + 0.005), (arg0\Field5 + (local14 * (1.0 / 256.0))), 90.0, rnd(360.0, 0.0), 0.0, 0.5, 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($03, (arg0\Field3 + 13.42969), (arg0\Field4 - 21.52344), (arg0\Field5 + 24.58594), 0.0, 270.0, 0.0, 0.3, 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($07, (arg0\Field3 + 4.230469), ((arg0\Field4 - 22.0) + 0.005), (arg0\Field5 + 3.476562), 90.0, 180.0, 0.0, 0.5, 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
        Case $26
            local0 = createdoor(arg0, (arg0\Field3 + 2.75), arg0\Field4, (arg0\Field5 - 1.3125), 0.0, $00, $04, $FFFFFFFA, $00, $00)
            local0\Field4 = $01
            local2 = createsecuritycam(arg0, (arg0\Field3 + 1.25), (arg0\Field4 + 2.125), (arg0\Field5 - 1.25), 30.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field17 = $01
            arg0\Field11[$00] = copyentity(mon_i\Field0[$01], arg0\Field2)
            positionentity(arg0\Field11[$00], (arg0\Field3 - 2.734375), (arg0\Field4 + 1.5), (arg0\Field5 + 1.132812), $01)
            scaleentity(arg0\Field11[$00], 2.0, 2.0, 2.0, $00)
            rotateentity(arg0\Field11[$00], 0.0, 0.0, 0.0, $00)
            local7 = createitem("Clipboard", $2D, (arg0\Field3 + 3.589844), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 3.339844), $00, $00, $00, 1.0, $00)
            local7\Field17 = local7\Field4\Field7
            setanimtime(local7\Field3, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local8 = createitem("Document SCP-1048", $00, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
            local8\Field26 = local7\Field19
            local8\Field15 = $01
            local8\Field16 = $FFFFFFFF
            local7\Field18[$00] = local8
            hideentity(local8\Field2)
            local8 = createitem("Level 2 Key Card", $5B, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
            local8\Field26 = local7\Field19
            local8\Field15 = $01
            local8\Field16 = $FFFFFFFF
            local7\Field18[$01] = local8
            hideentity(local8\Field2)
        Case $27
            local0 = createdoor(arg0, (arg0\Field3 + (1.0 / 1.28)), arg0\Field4, arg0\Field5, 0.0, $00, $00, $05, $00, $00)
            local0\Field12 = $15E
            positionentity(local0\Field3[$00], arg0\Field3, entityy(local0\Field3[$00], $01), (arg0\Field5 - (1.0 / 1.179724)), $01)
            positionentity(local0\Field3[$01], arg0\Field3, entityy(local0\Field3[$01], $01), (arg0\Field5 + (1.0 / 1.179724)), $01)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 - (1.0 / 1.28)), arg0\Field4, arg0\Field5, 0.0, $00, $00, $05, $00, $00)
            local0\Field12 = $15E
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$01] = local0
            arg0\Field14[$00]\Field21 = arg0\Field14[$01]
            arg0\Field14[$01]\Field21 = arg0\Field14[$00]
            If (currmapgrid\Field0[(Int (floor((arg0\Field3 / 8.0)) + ((floor((arg0\Field5 / 8.0)) - 1.0) * 21.0)))] = $00) Then
                local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 4.007812), 0.0, $00, $02, $00, $00, $00)
                local0\Field4 = $01
                local0\Field16 = $01
                local0\Field23 = $00
                freeentity(local0\Field3[$00])
                local0\Field3[$00] = $00
            EndIf
            arg0\Field11[$00] = copyentity(mon_i\Field0[$01], arg0\Field2)
            positionentity(arg0\Field11[$00], arg0\Field3, (arg0\Field4 + 1.5), (arg0\Field5 + 1.0), $01)
            scaleentity(arg0\Field11[$00], 2.0, 2.0, 2.0, $00)
            rotateentity(arg0\Field11[$00], 0.0, 180.0, 0.0, $00)
            arg0\Field11[$01] = copyentity(mon_i\Field0[$01], arg0\Field2)
            positionentity(arg0\Field11[$01], arg0\Field3, (arg0\Field4 + 1.5), (arg0\Field5 - 1.0), $01)
            scaleentity(arg0\Field11[$01], 2.0, 2.0, 2.0, $00)
            rotateentity(arg0\Field11[$01], 0.0, 0.0, 0.0, $00)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 0.75), (arg0\Field4 + 2.75), (arg0\Field5 + 3.75), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 225.0
            local2\Field9 = 0.0
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - (1.0 / 0.512)))
        Case $29
            local0 = createdoor(arg0, (arg0\Field3 - 1.15625), arg0\Field4, (arg0\Field5 - 2.625), 180.0, $01, $06, $07, $00, $00)
            local0\Field20 = $00
            local0\Field4 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            positionentity(local0\Field3[$01], (arg0\Field3 - 0.640625), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field14[$00] = local0
            local22 = loadtexture_strict("GFX\Map\Textures\Door01_Corrosive.png", $01, $00, $01)
            local0 = createdoor(arg0, (arg0\Field3 - 1.15625), arg0\Field4, (arg0\Field5 - 0.5625), 0.0, $00, $06, $07, $00, $00)
            local0\Field20 = $00
            local0\Field4 = $01
            local0\Field27 = $01
            positionentity(local0\Field3[$00], (arg0\Field3 - 1.710938), entityy(local0\Field3[$00], $01), (arg0\Field5 - 1.875), $01)
            rotateentity(local0\Field3[$00], 0.0, 90.0, 0.0, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            entitytexture(local0\Field0, local22, $00, $00)
            entitytexture(local0\Field1, local22, $00, $00)
            entitytexture(local0\Field2, local22, $00, $00)
            deletesingletextureentryfromcache(local22, $00)
            local22 = $00
            arg0\Field14[$01] = local0
            arg0\Field14[$00]\Field21 = arg0\Field14[$01]
            arg0\Field14[$01]\Field21 = arg0\Field14[$00]
            local0 = createdoor(arg0, (arg0\Field3 + 1.5), arg0\Field4, (arg0\Field5 - 2.625), 180.0, $00, $00, $07, $00, $00)
            arg0\Field14[$02] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 3.0), arg0\Field4, (arg0\Field5 + 2.0), 90.0, $00, $00, $00, $1663, $00)
            arg0\Field14[$03] = local0
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 + (1.0 / 1.22488)), (arg0\Field4 + 0.875), (arg0\Field5 - (1.0 / 1.24878)), -270.0, $00)
            arg0\Field13[$01] = createlever(arg0, (arg0\Field3 + (1.0 / 1.22488)), (arg0\Field4 + 0.875), (arg0\Field5 - 0.515625), -270.0, $00)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 1.78125), (arg0\Field4 + 0.5), (arg0\Field5 + (1.0 / 0.64)), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - 2.25), (arg0\Field4 + 0.5), (arg0\Field5 + 2.5), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 - 2.8125), (arg0\Field4 + 0.5), (arg0\Field5 + 3.4375), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 + 0.6875), (arg0\Field4 + 0.5), (arg0\Field5 - 0.5625), $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = loadmesh_strict("GFX\Map\Props\cont1_035_label.b3d", $00)
            update035label(arg0\Field11[$04])
            scaleentity(arg0\Field11[$04], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$04], (arg0\Field3 - (1.0 / 8.533334)), (arg0\Field4 + (1.0 / 1.113043)), (arg0\Field5 - 2.75), $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            local7 = createitem("SCP-035 Addendum", $00, (arg0\Field3 + 2.683594), (arg0\Field4 + 0.9375), (arg0\Field5 + (1.0 / 2.015748)), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Radio Transceiver", $45, (arg0\Field3 - 2.125), (arg0\Field4 + 0.5), (arg0\Field5 + 2.75), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("SCP-500-01", $16, (arg0\Field3 + 4.5625), (arg0\Field4 + (1.0 / 1.024)), (arg0\Field5 + 2.25), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Metal Panel", $0C, (arg0\Field3 - 1.40625), (arg0\Field4 + 0.5), (arg0\Field5 + 2.515625), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-035", $00, (arg0\Field3 + 4.5625), (arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 + 1.59375), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 3.3125))
        Case $2A
            local0 = createdoor(arg0, (arg0\Field3 - 6.4375), (arg0\Field4 - 41.75), (arg0\Field5 + 4.804688), 90.0, $00, $03, $06, $00, $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - 7.398438), entityy(local0\Field3[$00], $01), (arg0\Field5 + 6.542969), $01)
            rotateentity(local0\Field3[$00], 0.0, (entityyaw(local0\Field3[$00], $01) + 180.0), 0.0, $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - 5.539062), entityy(local0\Field3[$01], $01), (arg0\Field5 + 6.101562), $01)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 2.0), arg0\Field4, (arg0\Field5 - 1.0), -90.0, $01, $01, $00, $00, $00)
            positionentity(local0\Field24[$01], entityx(local0\Field24[$01], $01), (entityy(local0\Field24[$01], $01) + 0.05), entityz(local0\Field24[$01], $01), $01)
            arg0\Field14[$01] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 2.0), (arg0\Field4 - 40.0), (arg0\Field5 - 1.0), -90.0, $00, $01, $00, $00, $00)
            arg0\Field14[$02] = local0
            createdoor(arg0, (arg0\Field3 - 4.695312), (arg0\Field4 - 41.75), (arg0\Field5 + 3.40625), 0.0, $00, $00, $FFFFFFFF, $00, $00)
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 + 0.25), 0.0, $00, $02, $06, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            local0\Field16 = $01
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field11[$00] = loadanimmesh_strict("GFX\Map\Props\scp_079.b3d", $00)
            arg0\Field12[$00] = $01
            positionentity(arg0\Field11[$00], (arg0\Field3 + (1.0 / 1.542169)), (arg0\Field4 - 42.1875), (arg0\Field5 + 6.273438), $00)
            scaleentity(arg0\Field11[$00], 1.3, 1.3, 1.3, $00)
            rotateentity(arg0\Field11[$00], 0.0, -90.0, 0.0, $01)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            hideentity(arg0\Field11[$00])
            arg0\Field11[$01] = createsprite(arg0\Field11[$00])
            arg0\Field12[$01] = $01
            spriteviewmode(arg0\Field11[$01], $02)
            positionentity(arg0\Field11[$01], 0.082, 0.119, 0.01, $00)
            scalesprite(arg0\Field11[$01], 0.09, 0.0725)
            turnentity(arg0\Field11[$01], 0.0, 13.0, 0.0, $00)
            moveentity(arg0\Field11[$01], 0.0, 0.0, -0.022)
            entitytexture(arg0\Field11[$01], mon_i\Field1[$05], $00, $00)
            hideentity(arg0\Field11[$01])
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 + 3.1875), (arg0\Field4 + 0.9375), (arg0\Field5 - 1.0), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 + 3.1875), (arg0\Field4 - (1.0 / 0.0256)), (arg0\Field5 - 1.0), $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 1.0))
        Case $2B
            local0 = createdoor(arg0, (arg0\Field3 - 2.75), arg0\Field4, (arg0\Field5 - 2.75), 90.0, $01, $01, $00, $00, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 2.75), (arg0\Field4 - 28.62461), (arg0\Field5 - 2.75), 90.0, $00, $01, $00, $00, $00)
            arg0\Field14[$01] = local0
            createdoor(arg0, (arg0\Field3 - (1.0 / 1.438202)), (arg0\Field4 - 28.625), (arg0\Field5 - 1.648438), 0.0, $00, $00, $06, $00, $00)
            createdoor(arg0, (arg0\Field3 - 4.453125), (arg0\Field4 - 31.64062), (arg0\Field5 + 6.300781), 180.0, $00, $00, $06, $00, $00)
            createdoor(arg0, (arg0\Field3 - 2.976562), (arg0\Field4 - 33.625), (arg0\Field5 + (1.0 / 5.019608)), 90.0, $00, $00, $06, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 + 1.5), arg0\Field4, (arg0\Field5 - 2.75), 90.0, $00, $02, $06, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            local0 = createdoor(arg0, (arg0\Field3 - 1.125), (arg0\Field4 - 28.625), (arg0\Field5 - 6.257812), 0.0, $00, $02, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 - 2.90625), (arg0\Field4 - 30.89062), (arg0\Field5 + 12.19922), 0.0, $01)
            arg0\Field13[$01] = createlever(arg0, (arg0\Field3 - 2.597656), (arg0\Field4 - 30.89062), (arg0\Field5 + 12.19922), 0.0, $00)
            local2 = createsecuritycam(arg0, (arg0\Field3 + 3.0), (arg0\Field4 - 23.1875), (arg0\Field5 + 6.375), 45.0, $01, (arg0\Field3 - 1.804688), (arg0\Field4 - 30.75), (arg0\Field5 + 12.12891), 0.0, -10.0, 0.0)
            local2\Field8 = 315.0
            local2\Field9 = 20.0
            local2\Field22 = $01
            hideentity(local2\Field0)
            arg0\Field16[$00] = local2
            local2 = createsecuritycam(arg0, (arg0\Field3 - 5.621094), (arg0\Field4 - 29.9375), (arg0\Field5 + 6.675781), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 315.0
            local2\Field9 = 30.0
            arg0\Field11[$00] = createbutton($00, (arg0\Field3 - 1.316406), (arg0\Field4 - 30.875), (arg0\Field5 + 12.25), 0.0, 0.0, 0.0, arg0\Field2, $00)
            arg0\Field11[$01] = loadrmesh("GFX\Map\cont1_106_box.rmesh", Null, $00)
            scaleentity(arg0\Field11[$01], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$01], (arg0\Field3 + 2.703125), (arg0\Field4 - 32.45312), (arg0\Field5 + 4.03125), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 - 3.9375), (arg0\Field4 + 0.9375), (arg0\Field5 - 2.75), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 - 3.9375), (arg0\Field4 - 27.6875), (arg0\Field5 - 2.75), $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = loadmesh_strict("GFX\Map\cont1_106_hb.b3d", arg0\Field2)
            arg0\Field12[$04] = $01
            entitypickmode(arg0\Field11[$04], $02, $01)
            entityalpha(arg0\Field11[$04], 0.0)
            arg0\Field11[$05] = loadanimmesh_strict("GFX\Map\Props\femur_breaker.b3d", $00)
            local24 = (1.0 / 3938.462)
            scaleentity(arg0\Field11[$05], local24, local24, local24, $00)
            positionentity(arg0\Field11[$05], (arg0\Field3 + 4.238281), (arg0\Field4 - 25.0), (arg0\Field5 + 7.550781), $00)
            rotateentity(arg0\Field11[$05], 0.0, 180.0, 0.0, $00)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            local7 = createitem("Level 5 Key Card", $5E, (arg0\Field3 - 4.980469), (arg0\Field4 - 30.89844), (arg0\Field5 + 12.13281), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Dr. Allok's Note", $00, (arg0\Field3 - (1.0 / 2.942529)), (arg0\Field4 - 30.875), (arg0\Field5 + 9.902344), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Recall Protocol RP-106-N", $00, (arg0\Field3 - 3.863281), (arg0\Field4 - 31.28125), (arg0\Field5 + 12.13672), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, (arg0\Field3 - 0.515625), (arg0\Field5 - 2.75))
        Case $2C
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 1.75), 0.0, $00, $03, $04, $00, $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - 1.523438), entityy(local0\Field3[local25], $01), (arg0\Field5 - 1.09375), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.025), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field14[$00] = local0
            createdoor(arg0, (arg0\Field3 - 1.628906), arg0\Field4, arg0\Field5, 90.0, $01, $00, $04, $00, $00)
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 - 3.125), (arg0\Field4 + 0.703125), (arg0\Field5 - 1.324219), 180.0, $01)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], arg0\Field3, (arg0\Field4 - 5.984375), (arg0\Field5 + 9.796875), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            For local25 = $00 To $05 Step $01
                Select local25
                    Case $00
                        local12 = -667.0
                        local14 = 105.0
                        local24 = rnd(0.4, 0.5)
                    Case $01
                        local12 = -679.0
                        local14 = 157.0
                        local24 = rnd(0.4, 0.5)
                    Case $02
                        local12 = -542.0
                        local14 = 138.0
                        local24 = rnd(0.6, 0.7)
                    Case $03
                        local12 = -636.0
                        local14 = 204.0
                        local24 = rnd(0.1, 0.2)
                    Case $04
                        local12 = -819.0
                        local14 = 261.0
                        local24 = rnd(0.6, 0.7)
                    Case $05
                        local12 = -672.0
                        local14 = 299.0
                        local24 = rnd(0.7, 0.8)
                End Select
                local3 = createdecal($00, (arg0\Field3 + (local12 * (1.0 / 256.0))), (arg0\Field4 + 0.005), (arg0\Field5 + (local14 * (1.0 / 256.0))), 90.0, rnd(360.0, 0.0), 0.0, local24, rnd(0.6, 0.8), $01, $01, $00, $00, $00)
                entityparent(local3\Field0, arg0\Field2, $01)
            Next
            local2 = createsecuritycam(arg0, (arg0\Field3 - 1.25), (arg0\Field4 + 2.75), (arg0\Field5 + 1.125), 120.06, $01, (arg0\Field3 - 3.125), (arg0\Field4 + 1.125), (arg0\Field5 - 1.328125), 0.0, 180.0, 0.0)
            local2\Field8 = 225.0
            local2\Field9 = 45.0
            local2\Field18 = $01
            sc_i\Field4 = local2
            local7 = createitem("Document SCP-895", $00, (arg0\Field3 - 2.316406), (arg0\Field4 + 0.125), (arg0\Field5 + (1.0 / 3.282051)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Night Vision Goggles", $40, (arg0\Field3 + (1.0 / 5.12)), (arg0\Field4 - 5.085938), (arg0\Field5 + 9.433594), $00, $00, $00, 1.0, $00)
            local7\Field12 = rnd(0.0, 1000.0)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $2E
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 1.4375), arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - 1.4375), arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], ((arg0\Field3 + 0.875) - 0.005), (arg0\Field4 + 0.75), arg0\Field5, $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], ((arg0\Field3 - 0.875) + 0.005), (arg0\Field4 + 0.75), arg0\Field5, $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
        Case $30
            local0 = createdoor(arg0, (arg0\Field3 + 3.0), arg0\Field4, (arg0\Field5 - 3.232422), 90.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.1), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local25 = $00
            For local12 = -1.0 To 1.0 Step 2.0
                For local14 = -1.0 To 1.0 Step 1.0
                    local6 = setemitter(arg0, (arg0\Field3 + ((1.0 / 1.267327) * local12)), (arg0\Field4 + (1.0 / 32.0)), (arg0\Field5 + (1.0 * local14)), $03)
                    local6\Field11 = $01
                    local25 = (local25 + $01)
                Next
            Next
        Case $33
            local0 = createdoor(arg0, (arg0\Field3 + 1.0), arg0\Field4, (arg0\Field5 + 2.5625), -90.0, $01, $01, $00, $00, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 1.0), arg0\Field4, (arg0\Field5 - 2.5625), 90.0, $01, $01, $00, $00, $00)
            arg0\Field14[$02] = local0
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, $00, $03, $00, code_maintenance_tunnels, $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + (1.0 / 1.113043)), entityy(local0\Field3[$01], $01), (arg0\Field5 - 1.5), $01)
            rotateentity(local0\Field3[$00], 0.0, -90.0, 0.0, $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (1.0 / 1.113043)), entityy(local0\Field3[$01], $01), (arg0\Field5 + 1.5), $01)
            rotateentity(local0\Field3[$01], 0.0, 90.0, 0.0, $01)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 10.3125), (arg0\Field4 + 8.0), (arg0\Field5 + (1.0 / 0.64)), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - 16.9375), (arg0\Field4 + 8.0), (arg0\Field5 - 9.8125), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 + 2.1875), (arg0\Field4 + 0.9375), (arg0\Field5 + 2.5625), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], (arg0\Field3 - 2.1875), (arg0\Field4 + 0.9375), (arg0\Field5 - 2.5625), $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            local3 = createdecal($00, (arg0\Field3 + 0.25), (arg0\Field4 + 0.005), (arg0\Field5 + 0.5625), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local7 = createitem("Scorched Note", $00, (arg0\Field3 + 0.25), (arg0\Field4 + 0.125), (arg0\Field5 - 1.5), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 2.5625))
        Case $34
            local0 = createdoor(arg0, (arg0\Field3 + 4.6875), arg0\Field4, arg0\Field5, -90.0, $01, $01, $00, $00, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 4.6875), (arg0\Field4 + 14.875), arg0\Field5, -90.0, $00, $01, $00, $00, $00)
            arg0\Field14[$01] = local0
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 - 1.941406), (arg0\Field4 + 15.6875), (arg0\Field5 - 2.160156), -270.0, $01)
            arg0\Field13[$01] = createlever(arg0, (arg0\Field3 - 1.941406), (arg0\Field4 + 15.6875), (arg0\Field5 - 1.644531), -270.0, $01)
            local0 = createdoor(arg0, (arg0\Field3 + 2.25), arg0\Field4, (arg0\Field5 + 0.59375), 90.0, $00, $06, $07, $00, $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) - 0.09), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.09), $01)
            local0 = createdoor(arg0, (arg0\Field3 - 0.125), (arg0\Field4 + 14.875), (arg0\Field5 + 2.703125), 90.0, $00, $00, $07, $00, $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) - 0.075), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.075), $01)
            local0 = createdoor(arg0, (arg0\Field3 - 1.125), (arg0\Field4 + 14.875), (arg0\Field5 + 3.5), 180.0, $00, $00, $07, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 5.875), (arg0\Field4 + 0.9375), arg0\Field5, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 + 5.875), (arg0\Field4 + 15.8125), arg0\Field5, $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            local7 = createitem("Nuclear Device Document", $00, (arg0\Field3 - 1.8125), (arg0\Field4 + 15.46094), (arg0\Field5 - 2.773438), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Ballistic Vest", $27, (arg0\Field3 - 0.96875), (arg0\Field4 + 15.46094), (arg0\Field5 - 3.195312), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, -90.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local2 = createsecuritycam(arg0, (arg0\Field3 + 4.378906), (arg0\Field4 + 16.37109), (arg0\Field5 - 1.195312), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 90.0
            local2\Field9 = 45.0
        Case $35
            local0 = createdoor(arg0, (arg0\Field3 - 0.875), arg0\Field4, (arg0\Field5 - 2.875), 90.0, $01, $00, $00, $00, $00)
            local0\Field20 = $00
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 0.875), arg0\Field4, (arg0\Field5 + 2.875), 90.0, $01, $00, $00, $00, $00)
            local0\Field20 = $00
            arg0\Field14[$01] = local0
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 - 4.921875), (arg0\Field4 + (1.0 / 1.094017)), (arg0\Field5 + 2.941406), 0.0, $00)
            arg0\Field13[$01] = createlever(arg0, (arg0\Field3 - 3.582031), (arg0\Field4 + 0.640625), (arg0\Field5 + 3.511719), 0.0, $00)
            arg0\Field13[$02] = createlever(arg0, (arg0\Field3 - 3.269531), (arg0\Field4 + 0.59375), (arg0\Field5 + 3.464844), 0.0, $00)
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, $00, $02, $00, $00, $00)
            local0\Field4 = $01
            arg0\Field11[$00] = loadmesh_strict("GFX\Map\room2_servers_hcz_hb.b3d", arg0\Field2)
            arg0\Field12[$00] = $01
            entitypickmode(arg0\Field11[$00], $02, $01)
            entityalpha(arg0\Field11[$00], 0.0)
            hideentity(arg0\Field11[$00])
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 2.953125))
        Case $36
            createdoor(arg0, (arg0\Field3 + 1.0), arg0\Field4, (arg0\Field5 + 2.90625), 90.0, $00, $00, $03, $00, $00)
            createdoor(arg0, (arg0\Field3 + 6.058594), arg0\Field4, (arg0\Field5 + 1.9375), 0.0, $00, $00, $00, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 + 7.75), arg0\Field4, (arg0\Field5 + 2.90625), 90.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 6.058594), arg0\Field4, (arg0\Field5 + (1.0 / 1.098712)), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createbutton($00, (arg0\Field3 + 4.609375), (arg0\Field4 + 0.703125), (arg0\Field5 - 2.15625), 0.0, 270.0, 0.0, arg0\Field2, $01)
            local3 = createdecal($03, (arg0\Field3 + 5.210938), ((arg0\Field4 - 3.109375) + 0.01), (arg0\Field5 - 0.859375), 90.0, rnd(360.0, 0.0), 0.0, 0.25, 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local7 = createitem("Level 2 Key Card", $5B, (arg0\Field3 + 3.867188), (arg0\Field4 + (1.0 / 1.098712)), (arg0\Field5 + 1.683594), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("First Aid Kit", $34, (arg0\Field3 + 4.042969), (arg0\Field4 + (1.0 / 1.765517)), (arg0\Field5 + 0.21875), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 90.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery((arg0\Field3 + 7.539062), (arg0\Field4 + (1.0 / 2.639175)), (arg0\Field5 + 1.0))
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery((arg0\Field3 + 4.441406), (arg0\Field4 + (1.0 / 1.590062)), (arg0\Field5 + 1.6875))
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 + 7.539062), (arg0\Field4 + (1.0 / 1.137778)), (arg0\Field5 + 0.5), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $38
            local0 = createdoor(arg0, (arg0\Field3 + 2.8125), arg0\Field4, arg0\Field5, 0.0, $00, $02, $FFFFFFFD, $00, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 2.4375), (arg0\Field4 - 5.0), arg0\Field5, 90.0, $01, $00, $00, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.031), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.031), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            For local12 = 0.0 To 1.0 Step 1.0
                For local14 = -1.0 To 1.0 Step 1.0
                    arg0\Field11[(Int ((local12 * 3.0) + (local14 + 1.0)))] = createpivot($00)
                    positionentity(arg0\Field11[(Int ((local12 * 3.0) + (local14 + 1.0)))], (arg0\Field3 + (((280.0 * local12) + -236.0) * (1.0 / 256.0))), (arg0\Field4 - 2.734375), (arg0\Field5 + ((384.0 * local14) * (1.0 / 256.0))), $00)
                    entityparent(arg0\Field11[(Int ((local12 * 3.0) + (local14 + 1.0)))], arg0\Field2, $01)
                Next
            Next
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], (arg0\Field3 + 2.945312), (arg0\Field4 - 4.875), arg0\Field5, $00)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            arg0\Field11[$07] = loadmesh_strict("GFX\Map\room2_test_hcz_hb.b3d", arg0\Field2)
            arg0\Field12[$07] = $01
            entitypickmode(arg0\Field11[$07], $02, $01)
            entityalpha(arg0\Field11[$07], 0.0)
            local2 = createsecuritycam(arg0, (arg0\Field3 + 2.90625), (arg0\Field4 - 3.34375), (arg0\Field5 + 0.921875), 0.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field17 = $01
            local7 = createitem("Document SCP-682", $00, (arg0\Field3 + 2.5625), (arg0\Field4 - 4.6875), (arg0\Field5 - (1.0 / 16.0)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 3.1875))
        Case $39
            local0 = createdoor(arg0, (arg0\Field3 - 0.375), (arg0\Field4 - 19.9375), (arg0\Field5 - 1.5), 180.0, $01, $06, $06, $00, $00)
            local0\Field20 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.08), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 0.375), (arg0\Field4 - 19.9375), (arg0\Field5 + 1.0), 0.0, $00, $06, $06, $00, $00)
            local0\Field20 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 + (1.0 / 3.657143)), entityy(local0\Field3[$00], $01), (arg0\Field5 - 0.09375), $01)
            rotateentity(local0\Field3[$00], 0.0, -90.0, 0.0, $01)
            arg0\Field14[$01] = local0
            arg0\Field14[$00]\Field21 = arg0\Field14[$01]
            arg0\Field14[$01]\Field21 = arg0\Field14[$00]
            local0 = createdoor(arg0, (arg0\Field3 - 1.78125), (arg0\Field4 - 19.9375), (arg0\Field5 - 3.0), 0.0, $00, $00, $06, $00, $00)
            local0\Field4 = $01
            arg0\Field14[$02] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 3.1875), (arg0\Field4 - 19.9375), (arg0\Field5 - 1.5), 0.0, $00, $00, $06, $00, $00)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.08), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field4 = $01
            arg0\Field14[$03] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 1.75), arg0\Field4, arg0\Field5, -90.0, $01, $01, $00, $00, $00)
            arg0\Field14[$04] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 1.75), (arg0\Field4 - 19.9375), arg0\Field5, -90.0, $00, $01, $00, $00, $00)
            arg0\Field14[$05] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 0.375), (arg0\Field4 - 19.9375), (arg0\Field5 - 2.25), 90.0, $00, $00, $00, $00, $00)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.08), $01)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - (1.0 / 4.129032)), (arg0\Field4 - 19.47266), (arg0\Field5 + 3.472656), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = loadrmesh("GFX\Map\scp_008_lid.rmesh", Null, $00)
            scaleentity(arg0\Field11[$01], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - (1.0 / 4.129032)), (arg0\Field4 - 19.34375), (arg0\Field5 + 3.691406), $00)
            entityradius(arg0\Field11[$01], 0.4, 0.0)
            entitypickmode(arg0\Field11[$01], $01, $00)
            rotateentity(arg0\Field11[$01], 85.0, 0.0, 0.0, $01)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createsprite($00)
            arg0\Field12[$02] = $01
            local22 = loadtexture_strict("GFX\Map\Textures\glass.png", $03, $00, $00)
            textureblend(local22, $02)
            entitytexture(arg0\Field11[$02], local22, $00, $00)
            deletesingletextureentryfromcache(local22, $00)
            local22 = $00
            arg0\Field11[$03] = copyentity(arg0\Field11[$02], $00)
            For local25 = $02 To $03 Step $01
                spriteviewmode(arg0\Field11[local25], $02)
                scalesprite(arg0\Field11[local25], (1.0 / 2.639175), (1.0 / 2.639175))
                positionentity(arg0\Field11[local25], (arg0\Field3 - 2.5), (arg0\Field4 - 19.06641), (arg0\Field5 + 3.125), $00)
                turnentity(arg0\Field11[local25], 0.0, (90.0 + (Float ((local25 = $03) * $B4))), 0.0, $00)
                entityparent(arg0\Field11[local25], arg0\Field2, $01)
                hideentity(arg0\Field11[local25])
            Next
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], (arg0\Field3 - 3.203125), (arg0\Field4 - 19.47266), (arg0\Field5 + 2.566406), $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            arg0\Field11[$05] = createredlight((arg0\Field3 - 2.429688), (arg0\Field4 - 18.49609), (arg0\Field5 + 2.626953))
            arg0\Field12[$05] = $01
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            hideentity(arg0\Field11[$05])
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], (arg0\Field3 + 0.625), (arg0\Field4 + 2.617188), (arg0\Field5 - 1.5), $00)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            arg0\Field11[$07] = createpivot($00)
            positionentity(arg0\Field11[$07], arg0\Field3, (arg0\Field4 + 2.625), (arg0\Field5 + 1.367188), $00)
            entityparent(arg0\Field11[$07], arg0\Field2, $01)
            arg0\Field11[$08] = createpivot($00)
            positionentity(arg0\Field11[$08], (arg0\Field3 + 2.9375), (arg0\Field4 + 0.9375), arg0\Field5, $00)
            entityparent(arg0\Field11[$08], arg0\Field2, $01)
            arg0\Field11[$09] = createpivot($00)
            positionentity(arg0\Field11[$09], (arg0\Field3 + 2.9375), (arg0\Field4 - 19.0), arg0\Field5, $00)
            entityparent(arg0\Field11[$09], arg0\Field2, $01)
            arg0\Field11[$0A] = loadrmesh("GFX\Map\cont2_008_mt_generator.rmesh", Null, $01)
            scaleentity(arg0\Field11[$0A], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field11[$0A], arg0\Field3, arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field11[$0A], arg0\Field2, $01)
            hideentity(arg0\Field11[$0A])
            local7 = createitem("Hazmat Suit", $3C, (arg0\Field3 - 2.097656), (arg0\Field4 - 19.12109), (arg0\Field5 - (1.0 / 3.878788)), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 90.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-008", $00, (arg0\Field3 - 3.6875), (arg0\Field4 - 19.5625), (arg0\Field5 + 2.625), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery((arg0\Field3 - 3.671875), (arg0\Field4 - 19.35156), (arg0\Field5 + 3.140625))
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Infected Syringe", $58, (arg0\Field3 - 3.199219), (arg0\Field4 - 19.375), (arg0\Field5 - 5.671875), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("First Aid Kit", $34, (arg0\Field3 - (1.0 / 4.491228)), (arg0\Field4 - 19.03516), (arg0\Field5 - 3.652344), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            rotateentity(local7\Field2, 0.0, 90.0, 0.0, $00)
            local2 = createsecuritycam(arg0, (arg0\Field3 + 1.5), (arg0\Field4 - 18.17969), (arg0\Field5 + 4.5625), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 135.0
            local2\Field9 = 45.0
        Case $3A
            local0 = createdoor(arg0, (arg0\Field3 + 1.25), arg0\Field4, (arg0\Field5 + 2.5), -90.0, $01, $01, $00, $00, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 11.8125), (arg0\Field4 - 13.75), (arg0\Field5 + 7.125), -90.0, $00, $01, $00, $00, $00)
            arg0\Field14[$01] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 2.625), arg0\Field4, (arg0\Field5 - 1.625), 0.0, $01, $01, $00, $00, $00)
            positionentity(local0\Field24[$01], entityx(local0\Field24[$01], $01), (entityy(local0\Field24[$01], $01) + 0.05), entityz(local0\Field24[$01], $01), $01)
            arg0\Field14[$02] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 10.80469), (arg0\Field4 - 13.75), (arg0\Field5 - 6.25), 0.0, $00, $01, $00, $00, $00)
            positionentity(local0\Field24[$01], entityx(local0\Field24[$01], $01), (entityy(local0\Field24[$01], $01) + 0.05), entityz(local0\Field24[$01], $01), $01)
            arg0\Field14[$03] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 1.0625), (arg0\Field4 - 13.875), (arg0\Field5 + 0.40625), 90.0, $01, $00, $00, $00, $00)
            local0\Field20 = $00
            arg0\Field14[$04] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 1.0625), (arg0\Field4 - 13.75), (arg0\Field5 - 7.125), 90.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            arg0\Field14[$05] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 1.0625), (arg0\Field4 - 13.75), (arg0\Field5 + 7.125), 90.0, $01, $00, $00, $00, $00)
            local0\Field20 = $00
            arg0\Field14[$06] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 1.0625), (arg0\Field4 - 13.875), (arg0\Field5 + (1.0 / 2.612245)), -90.0, $00, $03, $05, $00, $00)
            local0\Field20 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.91), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.2), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.85), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.2), $01)
            rotateentity(local0\Field3[$00], 0.0, -90.0, 0.0, $01)
            rotateentity(local0\Field3[$01], 0.0, 90.0, 0.0, $01)
            arg0\Field14[$07] = local0
            createdoor(arg0, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, $00, $02, $FFFFFFFE, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 - 3.5), arg0\Field4, (arg0\Field5 - 2.5), 90.0, $00, $02, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0 = createdoor(arg0, (arg0\Field3 - 10.80469), (arg0\Field4 - 13.75), (arg0\Field5 - 8.0), 0.0, $00, $02, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            local0 = createdoor(arg0, (arg0\Field3 + 10.625), (arg0\Field4 - 13.75), (arg0\Field5 + 8.0), 180.0, $00, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 + 3.378906), (arg0\Field4 - 13.17969), (arg0\Field5 - 3.335938), 270.0, $00)
            arg0\Field13[$01] = createlever(arg0, (arg0\Field3 - 3.183594), (arg0\Field4 - 13.28125), (arg0\Field5 + 4.285156), 180.0, $00)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 2.4375), (arg0\Field4 + 0.9375), (arg0\Field5 + 2.5), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 + 13.0), (arg0\Field4 - 12.8125), (arg0\Field5 + 7.125), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 - 2.625), (arg0\Field4 + 0.9375), (arg0\Field5 - 0.4375), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 - 10.80469), (arg0\Field4 - 12.8125), (arg0\Field5 - 5.0625), $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], (arg0\Field3 - 3.25), (arg0\Field4 - 13.60938), (arg0\Field5 + 6.140625), $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            arg0\Field11[$05] = createbutton($00, (arg0\Field3 - 1.226562), (arg0\Field4 - 13.15625), (arg0\Field5 - 2.390625), 0.0, 270.0, 0.0, arg0\Field2, $00)
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], (arg0\Field3 - 1.921875), (arg0\Field4 - 12.8125), (arg0\Field5 - 3.199219), $00)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            local7 = createitem("Document SCP-049", $00, (arg0\Field3 - 3.285156), (arg0\Field4 - 13.29688), (arg0\Field5 - 3.382812), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Level 4 Key Card", $5D, (arg0\Field3 - 2.203125), (arg0\Field4 - 13.32812), (arg0\Field5 + 2.726562), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("First Aid Kit", $34, (arg0\Field3 + 1.503906), (arg0\Field4 - 13.32812), (arg0\Field5 + 1.058594), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, (arg0\Field3 - 2.625), (arg0\Field5 - 2.5))
        Case $3B
            local0 = createdoor(arg0, (arg0\Field3 + 1.0), arg0\Field4, (arg0\Field5 + 2.558594), -90.0, $01, $01, $00, $00, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 - 9.125), (arg0\Field4 - 16.625), (arg0\Field5 - 2.53125), -90.0, $00, $01, $00, $00, $00)
            arg0\Field14[$01] = local0
            createdoor(arg0, (arg0\Field3 - 17.0), (arg0\Field4 - 16.625), (arg0\Field5 + 5.34375), 0.0, $00, $00, $06, $00, $00)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 2.1875), (arg0\Field4 + 0.9375), (arg0\Field5 + 2.5625), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - 7.9375), (arg0\Field4 - 15.66797), (arg0\Field5 - 2.53125), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 - 19.20703), (arg0\Field4 - 16.83594), (arg0\Field5 + 8.183594), $00)
            entityradius(arg0\Field11[$02], 0.2, 0.0)
            entitypickmode(arg0\Field11[$02], $01, $01)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createbutton($01, (arg0\Field3 - 17.66797), (arg0\Field4 - 15.89062), (arg0\Field5 - 8.183594), 0.0, 180.0, 25.0, arg0\Field2, $01)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 14.19922), (arg0\Field4 - 15.0), (arg0\Field5 + 6.753906), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 100.0
            local2\Field9 = 45.0
        Case $3D
            createdoor(arg0, (arg0\Field3 - 0.234375), (arg0\Field4 - 2.375), (arg0\Field5 + 3.726562), 90.0, $00, $00, $05, $00, $00)
            createdoor(arg0, (arg0\Field3 + 1.015625), (arg0\Field4 - 2.375), (arg0\Field5 + 4.96875), 0.0, $00, $00, $05, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 - 6.855469), (arg0\Field4 - 2.375), (arg0\Field5 + 3.726562), 270.0, $00, $00, $05, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            local0\Field16 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local3 = createdecal($02, (arg0\Field3 - 4.734375), ((arg0\Field4 - 2.359375) + 0.005), (arg0\Field5 + 3.304688), 90.0, rnd(360.0, 0.0), 0.0, 0.8, 0.8, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($00, (arg0\Field3 - 4.859375), ((arg0\Field4 - 2.375) + 0.005), (arg0\Field5 + 2.226562), 90.0, rnd(360.0, 0.0), 0.0, 0.5, 0.5, $01, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local7 = createitem("Data Report", $00, (arg0\Field3 - 4.566406), (arg0\Field4 - 2.199219), (arg0\Field5 + 2.816406), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery(arg0\Field3, (arg0\Field4 - 1.738281), (arg0\Field5 + 5.957031))
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-096", $00, (arg0\Field3 + (1.0 / 18.28572)), (arg0\Field4 - 1.523438), (arg0\Field5 + 5.613281), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("SCRAMBLE Gear", $43, (arg0\Field3 + (1.0 / 11.63636)), (arg0\Field4 - 1.875), (arg0\Field5 + 7.0625), $00, $00, $00, 1.0, $00)
            local7\Field12 = rnd(0.0, 1000.0)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Dr. L's Note #2", $00, (arg0\Field3 - 0.625), (arg0\Field4 + 0.125), (arg0\Field5 - 1.378906), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local6 = setemitter(arg0, (arg0\Field3 + 2.0), (arg0\Field4 - 0.296875), (arg0\Field5 - 2.6875), $03)
            local6\Field11 = $01
            createcustomcenter(arg0, (arg0\Field3 + 1.328125), (arg0\Field5 - 1.328125))
        Case $3E
            local6 = setemitter(arg0, (arg0\Field3 + 2.0), (arg0\Field4 - 0.296875), (arg0\Field5 - 2.6875), $03)
            local6\Field11 = $01
            local6 = setemitter(arg0, (arg0\Field3 - 2.0), (arg0\Field4 - 0.296875), (arg0\Field5 - 2.6875), $03)
            local6\Field11 = $01
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 1.660156))
        Case $41
            local0 = createdoor(arg0, (arg0\Field3 - 2.75), (arg0\Field4 + 0.25), (arg0\Field5 + 1.1875), 0.0, $00, $00, $05, $00, $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.061), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.061), $01)
            local0 = createdoor(arg0, (arg0\Field3 - 2.0), (arg0\Field4 + 0.25), (arg0\Field5 + 2.554688), 90.0, $01, $00, $05, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.031), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            For local25 = $00 To $0B Step $01
                Select local25
                    Case $00
                        local12 = 0.0
                        local14 = 300.0
                        local24 = rnd(0.8, 1.0)
                    Case $01
                        local12 = -87.0
                        local14 = 466.0
                        local24 = rnd(0.1, 0.2)
                    Case $02
                        local12 = -177.0
                        local14 = 467.0
                        local24 = rnd(0.2, 0.3)
                    Case $03
                        local12 = -104.0
                        local14 = 185.0
                        local24 = rnd(0.3, 0.4)
                    Case $04
                        local12 = -13.0
                        local14 = 201.0
                        local24 = rnd(0.1, 0.15)
                    Case $05
                        local12 = 85.0
                        local14 = 97.0
                        local24 = rnd(0.2, 0.3)
                    Case $06
                        local12 = 205.0
                        local14 = 180.0
                        local24 = rnd(0.1, 0.2)
                    Case $07
                        local12 = 235.0
                        local14 = 114.0
                        local24 = rnd(0.1, 0.2)
                    Case $08
                        local12 = 182.0
                        local14 = 47.0
                        local24 = rnd(0.1, 0.2)
                    Case $09
                        local12 = 52.0
                        local14 = 200.0
                        local24 = rnd(0.2, 0.3)
                    Case $0A
                        local12 = 26.0
                        local14 = 86.0
                        local24 = rnd(0.8, 1.0)
                    Case $0B
                        local12 = -193.0
                        local14 = 138.0
                        local24 = rnd(0.3, 0.4)
                End Select
                local13 = (3.0 * (Float (local25 > $02)))
                local3 = createdecal($00, (arg0\Field3 + (local12 * (1.0 / 256.0))), ((arg0\Field4 + (local13 * (1.0 / 256.0))) + 0.005), (arg0\Field5 + (local14 * (1.0 / 256.0))), 90.0, rnd(360.0, 0.0), 0.0, local24, rnd(0.6, 0.8), $01, $01, $00, $00, $00)
                entityparent(local3\Field0, arg0\Field2, $01)
            Next
            local2 = createsecuritycam(arg0, (arg0\Field3 - 1.757812), (arg0\Field4 + 1.75), (arg0\Field5 + (1.0 / 1.024)), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 135.0
            local2\Field9 = 0.0
            local7 = createitem("SCP-513", $19, arg0\Field3, (arg0\Field4 + 0.765625), (arg0\Field5 + 2.558594), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Blood-stained Note", $00, (arg0\Field3 + 2.875), (arg0\Field4 + 1.0), (arg0\Field5 + 0.1875), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-513", $00, (arg0\Field3 - 1.835938), (arg0\Field4 + 0.40625), (arg0\Field5 - (1.0 / 3.413333)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Wallet", $2E, (arg0\Field3 - 1.648438), (arg0\Field4 + (1.0 / 1.706667)), (arg0\Field5 - 3.703125), $00, $00, $00, 1.0, $00)
            local7\Field17 = local7\Field4\Field7
            setanimtime(local7\Field3, 4.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local8 = createitem("Mastercard", $61, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
            local8\Field26 = local7\Field19
            local8\Field15 = $01
            local8\Field16 = $FFFFFFFF
            local8\Field12 = (Float rand($00, $06))
            local7\Field18[$00] = local8
            hideentity(local8\Field2)
            local8 = createitem("Asav Harn's Badge", $05, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
            local8\Field26 = local7\Field19
            local8\Field15 = $01
            local8\Field16 = $FFFFFFFF
            local7\Field18[$01] = local8
            hideentity(local8\Field2)
        Case $42
            local0 = createdoor(arg0, (arg0\Field3 - (1.0 / 0.64)), arg0\Field4, arg0\Field5, 90.0, $00, $00, $05, $00, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 1.875), 0.0, $00, $00, $05, $00, $00)
            arg0\Field14[$01] = local0
            createdoor(arg0, (arg0\Field3 - 2.78125), arg0\Field4, (arg0\Field5 - 1.125), 0.0, $00, $02, $FFFFFFFE, $00, $00)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], arg0\Field3, (arg0\Field4 + 0.4), (arg0\Field5 + 2.0), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], arg0\Field3, (arg0\Field4 + 0.4), arg0\Field5, $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 1.367188), (arg0\Field4 + 1.757812), (arg0\Field5 + 1.289062), 30.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = -45.0
            local2\Field9 = 0.0
            local7 = createitem("Night Vision Goggles", $40, (arg0\Field3 - 1.109375), (arg0\Field4 + 0.5), (arg0\Field5 + (1.0 / 1.292929)), $00, $00, $00, 1.0, $00)
            local7\Field12 = rnd(0.0, 1000.0)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, (arg0\Field3 + 1.914062), (arg0\Field5 - 1.914062))
        Case $43
            local6 = setemitter(arg0, (arg0\Field3 + 2.0), (arg0\Field4 - 0.296875), (arg0\Field5 - 2.6875), $03)
            local6\Field11 = $01
            local6 = setemitter(arg0, (arg0\Field3 - 2.0), (arg0\Field4 - 0.296875), (arg0\Field5 - 2.6875), $03)
            local6\Field11 = $01
            local6 = setemitter(arg0, (arg0\Field3 + 2.0), (arg0\Field4 - 0.296875), (arg0\Field5 + 2.6875), $03)
            local6\Field11 = $01
            local6 = setemitter(arg0, (arg0\Field3 - 2.0), (arg0\Field4 - 0.296875), (arg0\Field5 + 2.6875), $03)
            local6\Field11 = $01
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 1.660156))
        Case $45
            local0 = createdoor(arg0, (arg0\Field3 + (1.0 / 1.28)), arg0\Field4, arg0\Field5, 0.0, $00, $00, $07, $00, $00)
            local0\Field12 = $15E
            positionentity(local0\Field3[$00], arg0\Field3, entityy(local0\Field3[$00], $01), (arg0\Field5 - (1.0 / 1.179724)), $01)
            positionentity(local0\Field3[$01], arg0\Field3, entityy(local0\Field3[$01], $01), (arg0\Field5 + (1.0 / 1.179724)), $01)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 - (1.0 / 1.28)), arg0\Field4, arg0\Field5, 0.0, $00, $00, $07, $00, $00)
            local0\Field12 = $15E
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$01] = local0
            arg0\Field14[$00]\Field21 = arg0\Field14[$01]
            arg0\Field14[$01]\Field21 = arg0\Field14[$00]
            If (currmapgrid\Field0[(Int (floor((arg0\Field3 / 8.0)) + ((floor((arg0\Field5 / 8.0)) - 1.0) * 21.0)))] = $00) Then
                local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 4.007812), 0.0, $00, $00, $00, $00, $00)
                local0\Field4 = $01
                local0\Field16 = $01
                local0\Field23 = $00
                freeentity(local0\Field3[$00])
                local0\Field3[$00] = $00
                freeentity(local0\Field1)
                local0\Field1 = $00
            EndIf
            arg0\Field11[$00] = copyentity(mon_i\Field0[$01], arg0\Field2)
            positionentity(arg0\Field11[$00], arg0\Field3, (arg0\Field4 + 1.5), (arg0\Field5 + 1.0), $01)
            scaleentity(arg0\Field11[$00], 2.0, 2.0, 2.0, $00)
            rotateentity(arg0\Field11[$00], 0.0, 180.0, 0.0, $00)
            arg0\Field11[$01] = copyentity(mon_i\Field0[$01], arg0\Field2)
            positionentity(arg0\Field11[$01], arg0\Field3, (arg0\Field4 + 1.5), (arg0\Field5 - 1.0), $01)
            scaleentity(arg0\Field11[$01], 2.0, 2.0, 2.0, $00)
            rotateentity(arg0\Field11[$01], 0.0, 0.0, 0.0, $00)
            local2 = createsecuritycam(arg0, (arg0\Field3 + 0.75), (arg0\Field4 + 2.75), (arg0\Field5 - 3.75), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 45.0
            local2\Field9 = 0.0
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - (1.0 / 0.512)))
        Case $46
            local0 = createdoor(arg0, (arg0\Field3 + 2.8125), arg0\Field4, (arg0\Field5 + 2.0), -90.0, $01, $01, $00, $00, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 1.40625), 0.0, $00, $03, $07, $00, $00)
            local0\Field16 = $01
            local0\Field23 = $00
            positionentity(local0\Field3[$01], (arg0\Field3 + 1.648438), entityy(local0\Field3[$01], $01), (arg0\Field5 - 2.25), $01)
            rotateentity(local0\Field3[$01], 0.0, -90.0, 0.0, $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - 2.113281), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            rotateentity(local0\Field3[$00], 0.0, -220.0, 0.0, $01)
            arg0\Field14[$01] = local0
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 4.0), arg0\Field4, (arg0\Field5 + 2.0), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 2.8125))
        Case $47
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 4.0), 0.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 2.460938), arg0\Field4, (arg0\Field5 - 1.875), 0.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 4.257812), arg0\Field4, (arg0\Field5 - 1.875), 0.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 + 9.125), 0.0, $01, $03, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            local0 = createdoor(arg0, (arg0\Field3 + 22.3125), (arg0\Field4 - 4.875), (arg0\Field5 + 19.40625), 90.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.08), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 15.875), (arg0\Field4 - 4.875), (arg0\Field5 + 15.4375), 0.0, $00, $00, $04, $00, $00)
            local0\Field20 = $00
            arg0\Field14[$00] = local0
            For local4 = Each rooms
                If (local4\Field7\Field6 = $46) Then
                    local0 = createdoor(arg0, (arg0\Field3 + 5.96875), arg0\Field4, (arg0\Field5 - 0.25), -90.0, $00, $01, $00, $00, $00)
                    arg0\Field14[$01] = local0
                    local4\Field11[$01] = createpivot($00)
                    positionentity(local4\Field11[$01], (arg0\Field3 + 7.15625), arg0\Field4, (arg0\Field5 - 0.25), $00)
                    entityparent(local4\Field11[$01], arg0\Field2, $01)
                    Exit
                EndIf
            Next
            local0 = createdoor(arg0, (arg0\Field3 - 5.46875), (arg0\Field4 - 1.875), (arg0\Field5 + 9.0625), 0.0, (me\Field43 = $01), $00, $04, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.12), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.12), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0, (arg0\Field3 - 5.46875), (arg0\Field4 - 1.875), (arg0\Field5 + 17.0), 0.0, (me\Field43 = $01), $00, $04, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.12), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.12), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 + 4.640625), arg0\Field4, (arg0\Field5 + 7.65625), $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], arg0\Field3, (arg0\Field4 + 0.375), (arg0\Field5 + 25.0), $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            arg0\Field11[$05] = createpivot($00)
            positionentity(arg0\Field11[$05], (arg0\Field3 + 6.96875), (arg0\Field4 + 8.296875), (arg0\Field5 + 17.625), $00)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], (arg0\Field3 - 19.71875), (arg0\Field4 + 7.46875), (arg0\Field5 + 18.1875), $00)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            arg0\Field11[$07] = createpivot($00)
            positionentity(arg0\Field11[$07], (arg0\Field3 + 7.125), (arg0\Field4 + 0.22), (arg0\Field5 + 27.5625), $00)
            entityparent(arg0\Field11[$07], arg0\Field2, $01)
            arg0\Field11[$08] = createpivot($00)
            positionentity(arg0\Field11[$08], (arg0\Field3 - 7.125), (arg0\Field4 + 0.22), (arg0\Field5 + 27.5625), $00)
            entityparent(arg0\Field11[$08], arg0\Field2, $01)
            arg0\Field11[$0B] = createpivot($00)
            positionentity(arg0\Field11[$0B], (arg0\Field3 - 15.875), (arg0\Field4 - 4.875), (arg0\Field5 - 6.625), $00)
            entityparent(arg0\Field11[$0B], arg0\Field2, $01)
            arg0\Field11[$0D] = loadmesh_strict("GFX\Map\gateawall1.b3d", arg0\Field2)
            positionentity(arg0\Field11[$0D], (arg0\Field3 - 16.82812), (arg0\Field4 - 4.082031), (arg0\Field5 + 2.125), $01)
            entitycolor(arg0\Field11[$0D], 25.0, 25.0, 25.0)
            entitytype(arg0\Field11[$0D], $01, $00)
            arg0\Field11[$0E] = loadmesh_strict("GFX\Map\gateawall2.b3d", arg0\Field2)
            positionentity(arg0\Field11[$0E], (arg0\Field3 - 14.92188), (arg0\Field4 - 4.082031), (arg0\Field5 + 2.125), $01)
            entitycolor(arg0\Field11[$0E], 25.0, 25.0, 25.5)
            entitytype(arg0\Field11[$0E], $01, $00)
            arg0\Field11[$0F] = createpivot($00)
            positionentity(arg0\Field11[$0F], (arg0\Field3 - 13.9375), (arg0\Field4 - 4.253906), (arg0\Field5 + 19.3125), $00)
            entityparent(arg0\Field11[$0F], arg0\Field2, $01)
            arg0\Field11[$10] = loadmesh_strict("GFX\Map\gatea_hitbox1.b3d", arg0\Field2)
            arg0\Field12[$10] = $01
            entitypickmode(arg0\Field11[$10], $02, $01)
            entitytype(arg0\Field11[$10], $01, $00)
            entityalpha(arg0\Field11[$10], 0.0)
        Case $48
            local0 = createdoor(arg0, (arg0\Field3 + 2.8125), arg0\Field4, (arg0\Field5 + 5.625), 0.0, $01, $01, $00, $00, $00)
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 1.25), 0.0, $00, $03, $07, $00, $00)
            local0\Field16 = $01
            local0\Field23 = $00
            positionentity(local0\Field3[$01], (arg0\Field3 + 1.523438), entityy(local0\Field3[$01], $01), (arg0\Field5 - 2.0625), $01)
            rotateentity(local0\Field3[$01], 0.0, -90.0, 0.0, $01)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (arg0\Field5 - (1.0 / 1.292929)), $01)
            rotateentity(local0\Field3[$00], 0.0, -180.0, 0.0, $01)
            arg0\Field14[$01] = local0
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 2.8125), arg0\Field4, (arg0\Field5 + 6.8125), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 2.8125))
        Case $49
            For local4 = Each rooms
                If (local4\Field7\Field6 = $48) Then
                    local0 = createdoor(arg0, (arg0\Field3 - 21.1875), arg0\Field4, (arg0\Field5 - 5.359375), 0.0, $00, $01, $00, $00, $00)
                    arg0\Field14[$01] = local0
                    local4\Field11[$01] = createpivot($00)
                    positionentity(local4\Field11[$01], (arg0\Field3 - 21.1875), arg0\Field4, (arg0\Field5 - 4.171875), $00)
                    entityparent(local4\Field11[$01], arg0\Field2, $01)
                    Exit
                EndIf
            Next
            local0 = createdoor(arg0, (arg0\Field3 + 17.0), arg0\Field4, (arg0\Field5 - 1.921875), 0.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            arg0\Field14[$02] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 17.0), arg0\Field4, (arg0\Field5 + 1.945312), 0.0, $00, $00, $00, $00, $00)
            local0\Field20 = $00
            arg0\Field14[$03] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 12.6875), (arg0\Field4 - 3.625), (arg0\Field5 + 25.0), 0.0, $00, $06, $00, $FFFFFFFF, $00)
            local0\Field4 = $01
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field14[$04] = local0
            createdoor(arg0, (arg0\Field3 + 12.0), (arg0\Field4 - 3.625), (arg0\Field5 + 22.65625), 90.0, $00, $00, $05, $00, $00)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 + 20.32422), (arg0\Field4 + 5.640625), (arg0\Field5 - 6.792969), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 + 17.04297), (arg0\Field4 - 0.96875), (arg0\Field5 + 10.80469), $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], (arg0\Field3 + 20.28125), (arg0\Field4 + 5.5), (arg0\Field5 - 17.0), $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            arg0\Field11[$05] = createpivot($00)
            positionentity(arg0\Field11[$05], (arg0\Field3 + 17.0), arg0\Field4, (arg0\Field5 + 5.25), $00)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], (arg0\Field3 + 11.0), (arg0\Field4 + 0.9375), (arg0\Field5 - 11.0), $00)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            arg0\Field11[$08] = createpivot($00)
            positionentity(arg0\Field11[$08], (arg0\Field3 + 14.0625), (arg0\Field4 - 3.46875), (arg0\Field5 + 25.87109), $00)
            entityparent(arg0\Field11[$08], arg0\Field2, $01)
            arg0\Field11[$09] = createpivot($00)
            positionentity(arg0\Field11[$09], (arg0\Field3 + 14.875), (arg0\Field4 + 6.0), (arg0\Field5 - 53.0), $00)
            entityparent(arg0\Field11[$09], arg0\Field2, $01)
            arg0\Field11[$0A] = createpivot($00)
            positionentity(arg0\Field11[$0A], (arg0\Field3 - 30.0), (arg0\Field4 + 0.8125), (arg0\Field5 - 105.6562), $00)
            entityparent(arg0\Field11[$0A], arg0\Field2, $01)
            arg0\Field11[$0B] = createpivot($00)
            positionentity(arg0\Field11[$0B], (arg0\Field3 - 21.1875), arg0\Field4, (arg0\Field5 - 4.171875), $00)
            entityparent(arg0\Field11[$0B], arg0\Field2, $01)
            createcustomcenter(arg0, (arg0\Field3 - 21.1875), (arg0\Field5 - 6.640625))
        Case $4B
            local0 = createdoor(arg0, (arg0\Field3 - (1.0 / 1.07113)), arg0\Field4, (arg0\Field5 + 0.375), 0.0, $00, $01, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            freeentity(local0\Field24[$00])
            local0\Field24[$00] = $00
            local0 = createdoor(arg0, (arg0\Field3 + (1.0 / 1.07113)), arg0\Field4, (arg0\Field5 + 0.375), 0.0, $00, $01, $00, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 1.2), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            freeentity(local0\Field24[$00])
            local0\Field24[$00] = $00
            local2 = createsecuritycam(arg0, (arg0\Field3 + 1.5), (arg0\Field4 + 1.5), (arg0\Field5 - 3.75), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 45.0
            local2\Field9 = 45.0
        Case $4C
            createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 0.9375), 0.0, $00, $00, $00, code_o5_council, $00)
            local7 = createitem("Field Agent Log #235-001-CO5", $00, arg0\Field3, (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + 3.398438), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Groups of Interest Log", $00, (arg0\Field3 + (1.0 / 2.56)), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + (1.0 / 2.56)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("First Aid Kit", $34, (arg0\Field3 + 2.65625), (arg0\Field4 + 1.015625), (arg0\Field5 + 3.486328), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 90.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery((arg0\Field3 - 2.734375), (arg0\Field4 + (1.0 / 1.219048)), (arg0\Field5 + 3.59375))
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Ballistic Helmet", $26, (arg0\Field3 + 1.34375), (arg0\Field4 + (1.0 / 1.219048)), (arg0\Field5 - 3.515625), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("SCP-268", $0E, (arg0\Field3 + 1.132812), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + (1.0 / 1.505882)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 2.496094))
        Case $4D
            local7 = createitem("Document SCP-106", $00, (arg0\Field3 + 1.578125), (arg0\Field4 + (1.0 / 1.765517)), (arg0\Field5 + 2.183594), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Level 2 Key Card", $5B, (arg0\Field3 - 0.609375), (arg0\Field4 + (1.0 / 1.695364)), (arg0\Field5 + 0.28125), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("S-NAV Navigator", $49, (arg0\Field3 + 1.191406), (arg0\Field4 + (1.0 / 1.673203)), (arg0\Field5 + 3.6875), $00, $00, $00, 1.0, $00)
            local7\Field12 = rnd(100.0, 0.0)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Notification", $00, (arg0\Field3 - (1.0 / 1.868613)), (arg0\Field4 + (1.0 / 1.673203)), (arg0\Field5 + 1.8125), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $4E
            local7 = createitem("Level 1 Key Card", $5A, (arg0\Field3 - 1.4375), (arg0\Field4 - 0.1875), (arg0\Field5 + (1.0 / 3.2)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-895", $00, (arg0\Field3 - 3.125), (arg0\Field4 - 0.1875), (arg0\Field5 + 1.4375), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local7 = createitem("Document SCP-860", $00, (arg0\Field3 - 3.125), (arg0\Field4 - 0.1875), (arg0\Field5 - 1.8125), $00, $00, $00, 1.0, $00)
            Else
                local7 = createitem("SCP-093 Recovered Materials", $00, (arg0\Field3 - 3.125), (arg0\Field4 - 0.1875), (arg0\Field5 - 1.8125), $00, $00, $00, 1.0, $00)
            EndIf
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("S-NAV Navigator", $49, (arg0\Field3 - 1.3125), (arg0\Field4 - 0.1875), (arg0\Field5 - 1.875), $00, $00, $00, 1.0, $00)
            local7\Field12 = rnd(100.0, 0.0)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $4F
            createdoor(arg0, (arg0\Field3 - 4.125), (arg0\Field4 + 1.5), (arg0\Field5 + 1.132812), 90.0, $00, $00, $05, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 - 4.125), (arg0\Field4 + 1.5), (arg0\Field5 - 2.875), 270.0, $01, $06, $03, $00, $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 1.2), $01)
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field7\Field6 = $4F) Then
                        arg0\Field11[$00] = copyentity(local4\Field11[$00], arg0\Field2)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field11[$00] = $00) Then
                arg0\Field11[$00] = loadmesh_strict("GFX\Map\room2_3_ez_hb.b3d", arg0\Field2)
            EndIf
            arg0\Field12[$00] = $01
            entitypickmode(arg0\Field11[$00], $02, $01)
            entitytype(arg0\Field11[$00], $01, $00)
            entityalpha(arg0\Field11[$00], 0.0)
            If (rand($02, $01) = $01) Then
                local7 = createitem("Mobile Task Forces", $00, (arg0\Field3 + 2.90625), (arg0\Field4 + 0.9375), (arg0\Field5 - 3.6875), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            Else
                local7 = createitem("Security Clearance Levels", $00, (arg0\Field3 + 2.65625), (arg0\Field4 + 0.9375), (arg0\Field5 - 3.6875), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            local7 = createitem("Object Classes", $00, (arg0\Field3 + 0.625), (arg0\Field4 + 0.9375), (arg0\Field5 + 2.21875), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document", $00, (arg0\Field3 - 5.625), (arg0\Field4 + 2.4375), (arg0\Field5 + 1.023438), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Radio Transceiver", $45, (arg0\Field3 - 4.625), (arg0\Field4 + 1.875), (arg0\Field5 - 3.125), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 - 5.976562), (arg0\Field4 + 2.199219), (arg0\Field5 - 2.050781), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            If (rand($03, $01) = $01) Then
                local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 - 5.976562), (arg0\Field4 + 2.199219), (arg0\Field5 - (1.0 / 0.4096)), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            local7 = createrandombattery((arg0\Field3 - 6.035156), (arg0\Field4 + 2.363281), (arg0\Field5 - 1.53125))
            entityparent(local7\Field2, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local7 = createrandombattery((arg0\Field3 - 6.015625), (arg0\Field4 + 1.933594), (arg0\Field5 - 1.25))
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local7 = createrandombattery((arg0\Field3 - 5.972656), (arg0\Field4 + 2.363281), (arg0\Field5 - 1.203125))
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
        Case $52
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field7\Field6 = $52) Then
                        arg0\Field11[$00] = copyentity(local4\Field11[$00], $00)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field11[$00] = $00) Then
                arg0\Field11[$00] = loadanimmesh_strict("GFX\Map\Props\scp_789_j.b3d", $00)
            EndIf
            local24 = (1.0 / 102.4)
            scaleentity(arg0\Field11[$00], local24, local24, local24, $00)
            entitytype(arg0\Field11[$00], $01, $00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 4.890625), arg0\Field4, (arg0\Field5 + (1.0 / 2.534653)), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            If (rand($03, $01) = $01) Then
                Select rand($04, $01)
                    Case $01
                        local12 = 925.0
                        local14 = 735.0
                    Case $02
                        local12 = 1109.0
                        local14 = 735.0
                    Case $03
                        local12 = 925.0
                        local14 = -735.0
                    Case $04
                        local12 = 1109.0
                        local14 = -735.0
                End Select
                local6 = setemitter(arg0, (arg0\Field3 + (local12 * (1.0 / 256.0))), (arg0\Field4 + (1.0 / 1.815603)), (arg0\Field5 + (local14 * (1.0 / 256.0))), $11)
                local6\Field11 = $03
            EndIf
        Case $53
            local0 = createdoor(arg0, (arg0\Field3 + 6.6875), (arg0\Field4 - 1.5), (arg0\Field5 - 4.0), 0.0, $00, $00, $04, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            local0\Field16 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 1.8125), (arg0\Field4 - 1.5), (arg0\Field5 - 4.0), 0.0, $00, $00, $03, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            local0\Field16 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 + 0.90625), (arg0\Field4 - 1.5), (arg0\Field5 + 2.390625), 90.0, $00, $06, $03, $00, $00)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.08), $01)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 + 6.949219), (arg0\Field4 - (1.0 / 1.551515)), (arg0\Field5 - 1.203125), $00)
            entityradius(arg0\Field11[$00], 0.1, 0.0)
            entitypickmode(arg0\Field11[$00], $01, $01)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], arg0\Field3, (arg0\Field4 - 0.75), (arg0\Field5 + 3.253906), $00)
            entityradius(arg0\Field11[$01], 0.2, 0.0)
            entitypickmode(arg0\Field11[$01], $01, $01)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 + 6.953125), (arg0\Field4 - 0.96875), (arg0\Field5 - 1.078125), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            local7 = createitem("Cup", $2B, (arg0\Field3 - 1.984375), (arg0\Field4 - (1.0 / 1.368984)), (arg0\Field5 + 1.109375), $F0, $AF, $46, 1.0, $00)
            local7\Field1 = "ORANGE JUICE"
            local7\Field0 = format(getlocalstring("items", "cupof"), getlocalstring("misc", "orange"), "%s")
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Cup", $2B, (arg0\Field3 + 5.515625), (arg0\Field4 - (1.0 / 1.368984)), (arg0\Field5 - 2.796875), $57, $3E, $2D, 1.0, $00)
            local7\Field1 = "COFFEE"
            local7\Field0 = format(getlocalstring("items", "cupof"), getlocalstring("misc", "coffee"), "%s")
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Pizza Slice", $6C, (arg0\Field3 - 2.1875), (arg0\Field4 - (1.0 / 1.132743)), (arg0\Field5 + 1.019531), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Pizza Slice", $6C, (arg0\Field3 + 4.136719), (arg0\Field4 - (1.0 / 1.132743)), (arg0\Field5 + 2.820312), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Pizza Slice", $6C, (arg0\Field3 + 4.457031), (arg0\Field4 - (1.0 / 1.132743)), (arg0\Field5 + 3.460938), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Pizza Slice", $6C, (arg0\Field3 + (1.0 / 0.15822)), (arg0\Field4 - (1.0 / 1.132743)), (arg0\Field5 + 3.429688), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Empty Cup", $2C, (arg0\Field3 - 2.109375), (arg0\Field4 - (1.0 / 1.368984)), (arg0\Field5 + 0.484375), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Quarter", $6A, (arg0\Field3 - 1.746094), (arg0\Field4 - 1.304688), (arg0\Field5 + 0.140625), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Quarter", $6A, (arg0\Field3 + 5.503906), (arg0\Field4 - 1.304688), (arg0\Field5 - 2.859375), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $54
            local0 = createdoor(arg0, (arg0\Field3 - 3.5), arg0\Field4, arg0\Field5, 90.0, $01, $01, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            local3 = createdecal($15, (arg0\Field3 - 2.777344), (arg0\Field4 + 0.005), (arg0\Field5 + 0.546875), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.8, 1.0), 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local7 = createitem("Bloody Level 0 Key Card", $59, (arg0\Field3 - 5.078125), (arg0\Field4 + 0.546875), (arg0\Field5 + (1.0 / 10.24)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Cup", $2B, (arg0\Field3 - (1.0 / 3.413333)), (arg0\Field4 + (1.0 / 1.113043)), (arg0\Field5 - 0.09375), $C8, $C8, $C8, 1.0, $00)
            local7\Field1 = "WATER"
            local7\Field0 = format(getlocalstring("items", "cupof"), getlocalstring("misc", "water"), "%s")
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Empty Cup", $2C, (arg0\Field3 + (1.0 / 1.79021)), (arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 + 3.773438), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, (arg0\Field3 - (1.0 / 0.64)), arg0\Field5)
        Case $55
            createdoor(arg0, (arg0\Field3 - 1.0), arg0\Field4, (arg0\Field5 + 2.5), 90.0, $00, $00, $04, $00, $00)
            createdoor(arg0, (arg0\Field3 - 2.0), arg0\Field4, (arg0\Field5 + 1.476562), 0.0, $00, $04, $00, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 - 4.3125), arg0\Field4, (arg0\Field5 + 2.5), 270.0, $00, $00, $04, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            If (rand($02, $01) = $01) Then
                local31 = $55
                local30 = "Syringe"
            Else
                local31 = $58
                local30 = "Infected Syringe"
            EndIf
            local7 = createitem(local30, local31, (arg0\Field3 - 3.605469), (arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 + 0.375), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local31 = $55
                local30 = "Syringe"
            Else
                local31 = $58
                local30 = "Infected Syringe"
            EndIf
            local7 = createitem(local30, local31, (arg0\Field3 - 3.542969), (arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 + (1.0 / 1.610063)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Compact First Aid Kit", $36, (arg0\Field3 - 1.300781), (arg0\Field4 + 0.75), (arg0\Field5 - (1.0 / 2.081301)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $56
            createdoor(arg0, (arg0\Field3 - 0.90625), (arg0\Field4 - 1.5), (arg0\Field5 - 2.515625), 90.0, $00, $00, $03, $00, $00)
            createdoor(arg0, (arg0\Field3 - 0.90625), (arg0\Field4 - 1.5), (arg0\Field5 + 2.515625), 90.0, $00, $00, $03, $00, $00)
            local7 = createitem("Sticky Note", $00, (arg0\Field3 - 3.871094), (arg0\Field4 - (1.0 / 1.057851)), (arg0\Field5 + 3.53125), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Document SCP-999", $00, (arg0\Field3 - 3.035156), (arg0\Field4 - 0.71875), (arg0\Field5 + 1.363281), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery((arg0\Field3 - 5.886719), (arg0\Field4 - (1.0 / 1.158371)), (arg0\Field5 - 1.984375))
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Quarter", $6A, (arg0\Field3 - 2.070312), (arg0\Field4 - (1.0 / 1.158371)), (arg0\Field5 + 3.683594), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $57
            createdoor(arg0, (arg0\Field3 + (1.0 / 1.094017)), arg0\Field4, arg0\Field5, 90.0, (rand($05, $01) = $01), $04, $00, $00, $00)
            arg0\Field11[$00] = loadmesh_strict("GFX\Map\room2_office_2_hb.b3d", arg0\Field2)
            arg0\Field12[$00] = $01
            entitypickmode(arg0\Field11[$00], $02, $01)
            entitytype(arg0\Field11[$00], $01, $00)
            entityalpha(arg0\Field11[$00], 0.0)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 1.855469), (arg0\Field4 + 1.503906), (arg0\Field5 + 1.191406), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 225.0
            local2\Field9 = 30.0
            local7 = createrandombattery((arg0\Field3 + 2.242188), (arg0\Field4 + (1.0 / 1.113043)), (arg0\Field5 + 3.75))
            entityparent(local7\Field2, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local7 = createrandombattery((arg0\Field3 + 1.65625), (arg0\Field4 + (1.0 / 1.113043)), (arg0\Field5 + 3.75))
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            If (rand($03, $01) = $01) Then
                local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 + 2.132812), (arg0\Field4 + (1.0 / 1.580247)), (arg0\Field5 - 3.746094), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
        Case $58
            local0 = createdoor(arg0, (arg0\Field3 + 5.015625), (arg0\Field4 + 0.875), arg0\Field5, 90.0, $00, $00, $07, $00, $00)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.1), $01)
            local0 = createdoor(arg0, (arg0\Field3 + 1.25), arg0\Field4, arg0\Field5, 90.0, $00, $00, $07, $00, $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) - 0.1), $01)
            local0 = createdoor(arg0, (arg0\Field3 - (1.0 / 1.094017)), arg0\Field4, (arg0\Field5 + 3.0), 270.0, $00, $04, $00, $00, $00)
            local0\Field4 = $02
            local0\Field23 = $00
            local7 = createitem("Some SCP-420-J", $10, (arg0\Field3 + 7.007812), (arg0\Field4 + (1.0 / 0.64)), (arg0\Field5 + 1.667969), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Some SCP-420-J", $10, (arg0\Field3 + 6.601562), (arg0\Field4 + (1.0 / 0.64)), (arg0\Field5 + 1.691406), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Level 5 Key Card", $5E, (arg0\Field3 + 8.203125), (arg0\Field4 + 1.53125), (arg0\Field5 + 1.511719), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Storage Transfers", $00, (arg0\Field3 + 8.203125), (arg0\Field4 + 1.71875), (arg0\Field5 + 1.453125), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Radio Transceiver", $45, (arg0\Field3 + 8.203125), (arg0\Field4 + 1.25), (arg0\Field5 + 0.5), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $59
            createdoor(arg0, (arg0\Field3 + 1.0), arg0\Field4, (arg0\Field5 + 2.625), 270.0, $00, $00, $06, $00, $00)
            createdoor(arg0, (arg0\Field3 - 2.0), (arg0\Field4 - 3.0), (arg0\Field5 - 1.25), 180.0, $00, $06, $06, $00, $00)
            local0 = createdoor(arg0, (arg0\Field3 - 2.0), (arg0\Field4 - 3.0), (arg0\Field5 - 4.0625), 0.0, $00, $00, $06, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local7 = createitem("Fine Night Vision Goggles", $42, (arg0\Field3 + 0.1875), (arg0\Field4 - 2.53125), (arg0\Field5 + 3.0625), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $5A
            createdoor(arg0, (arg0\Field3 + 1.0), arg0\Field4, (arg0\Field5 + 1.75), 270.0, $00, $00, $00, code_dr_maynard, $00)
            local0 = createdoor(arg0, (arg0\Field3 - 1.375), arg0\Field4, arg0\Field5, 270.0, $00, $00, $00, code_dr_gears, $00)
            createdoor(arg0, (arg0\Field3 + 1.0), arg0\Field4, (arg0\Field5 - 2.25), 270.0, $00, $00, $00, $1E88, $00)
            local7 = createitem("Mysterious Note", $00, (arg0\Field3 + 2.875), (arg0\Field4 + 0.875), (arg0\Field5 + 2.125), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Ballistic Vest", $27, (arg0\Field3 + 2.375), (arg0\Field4 + 0.4375), (arg0\Field5 + 0.125), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 90.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Incident Report SCP-106-0204", $00, (arg0\Field3 + 2.75), (arg0\Field4 + (1.0 / 1.398907)), (arg0\Field5 - 2.25), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Journal Page", $00, (arg0\Field3 + 3.5625), (arg0\Field4 + 0.6875), (arg0\Field5 - 0.625), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("First Aid Kit", $34, (arg0\Field3 + 3.5625), (arg0\Field4 + 0.4375), (arg0\Field5 - 1.3125), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 90.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("SCP-085", $00, (arg0\Field3 - 1.945312), (arg0\Field4 + (1.0 / 1.398907)), (arg0\Field5 + 1.679688), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Syringe", $55, (arg0\Field3 - 3.890625), (arg0\Field4 + (1.0 / 1.505882)), (arg0\Field5 + 0.515625), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Pizza Slice", $6C, (arg0\Field3 - 3.144531), (arg0\Field4 + (1.0 / 1.505882)), (arg0\Field5 + 1.015625), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            If (i_005\Field0 = $03) Then
                local7 = createitem("SCP-005", $08, (arg0\Field3 + 2.875), (arg0\Field4 + 0.875), (arg0\Field5 + 2.949219), $00, $00, $00, 1.0, $00)
            Else
                local7 = createitem("Level 4 Key Card", $5D, (arg0\Field3 + 2.875), (arg0\Field4 + 0.875), (arg0\Field5 + 2.949219), $00, $00, $00, 1.0, $00)
            EndIf
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $5B
            local22 = loadtexture_strict("GFX\Map\Textures\Door01_Corrosive.png", $01, $00, $01)
            local0 = createdoor(arg0, (arg0\Field3 - 1.375), arg0\Field4, arg0\Field5, 90.0, $00, $00, $00, $96B, $00)
            local0\Field23 = $00
            local0\Field16 = $01
            local0\Field27 = $01
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            entitytexture(local0\Field0, local22, $00, $00)
            entitytexture(local0\Field1, local22, $00, $00)
            entitytexture(local0\Field2, local22, $00, $00)
            deletesingletextureentryfromcache(local22, $00)
            local22 = $00
            arg0\Field14[$00] = local0
            createdoor(arg0, (arg0\Field3 + 1.0), arg0\Field4, arg0\Field5, 270.0, $00, $00, $07, $00, $00)
            local3 = createdecal($00, (arg0\Field3 - 2.78125), (arg0\Field4 + 0.005), (arg0\Field5 - 0.28125), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($02, (arg0\Field3 - 2.78125), (arg0\Field4 + 0.01), (arg0\Field5 - 0.28125), 90.0, rnd(360.0, 0.0), 0.0, 0.3, 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($00, (arg0\Field3 - 1.3125), (arg0\Field4 + 0.01), arg0\Field5, 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local7 = createitem("Dr. L's Burnt Note #1", $00, (arg0\Field3 - 2.3125), (arg0\Field4 + 1.0), (arg0\Field5 - (1.0 / 16.0)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Dr. L's Burnt Note #2", $00, (arg0\Field3 - 2.78125), (arg0\Field4 + 1.0), (arg0\Field5 - 0.28125), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("The Modular Site Project", $00, (arg0\Field3 + 2.429688), (arg0\Field4 + (1.0 / 2.048)), (arg0\Field5 - (1.0 / 3.506849)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $5D
            createdoor(arg0, (arg0\Field3 + 2.90625), arg0\Field4, (arg0\Field5 + 2.5), 0.0, $00, $00, $FFFFFFFD, $00, $00)
            createdoor(arg0, (arg0\Field3 + 2.90625), arg0\Field4, (arg0\Field5 - 2.5), 0.0, $00, $00, $FFFFFFFD, $00, $00)
            createdoor(arg0, (arg0\Field3 + 0.90625), arg0\Field4, (arg0\Field5 - 2.5), 0.0, $00, $00, $06, $00, $00)
            createdoor(arg0, (arg0\Field3 + 0.90625), arg0\Field4, (arg0\Field5 + 2.5), 0.0, $00, $00, $06, $00, $00)
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, $00, $05, $FFFFFFFC, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field38 = $01
            arg0\Field14[$00] = local0
            If (i_zone\Field1 = $00) Then
                local5 = (New forest)
                arg0\Field10 = local5
                genforestgrid(local5)
                placeforest(local5, arg0\Field3, (arg0\Field4 + 30.0), arg0\Field5, arg0)
            EndIf
            local7 = createitem("Document SCP-860-1", $00, (arg0\Field3 + 3.804688), (arg0\Field4 + (1.0 / 1.024)), (arg0\Field5 - (1.0 / 15.05882)), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            createcustomcenter(arg0, (arg0\Field3 + 2.902344), arg0\Field5)
        Case $5E
            local2 = createsecuritycam(arg0, (arg0\Field3 - 1.125), (arg0\Field4 + 1.5), (arg0\Field5 + 1.125), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 225.0
            local2\Field9 = 45.0
        Case $5F
            createdoor(arg0, (arg0\Field3 + 2.363281), arg0\Field4, (arg0\Field5 - (1.0 / 1.094017)), 0.0, (rand($04, $01) = $01), $04, $00, $00, $00)
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field7\Field6 = $5F) Then
                        arg0\Field11[$00] = copyentity(local4\Field11[$00], arg0\Field2)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field11[$00] = $00) Then
                arg0\Field11[$00] = loadmesh_strict("GFX\Map\room2C_2_ez_hb.b3d", arg0\Field2)
            EndIf
            arg0\Field12[$00] = $01
            entitypickmode(arg0\Field11[$00], $02, $01)
            entitytype(arg0\Field11[$00], $01, $00)
            entityalpha(arg0\Field11[$00], 0.0)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 1.125), (arg0\Field4 + 1.5), (arg0\Field5 + 1.125), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 225.0
            local2\Field9 = 45.0
            If (rand($03, $01) = $01) Then
                local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 + 1.570312), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 3.601562), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            Else
                local7 = createitem("Syringe", $55, (arg0\Field3 + 1.570312), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 3.601562), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            local7 = createitem("Cup", $2B, (arg0\Field3 + 2.078125), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 2.179688), $57, $3E, $2D, 1.0, $00)
            local7\Field1 = "COFFEE"
            local7\Field0 = format(getlocalstring("items", "cupof"), getlocalstring("misc", "coffee"), "%s")
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createrandombattery((arg0\Field3 + 3.4375), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 1.171875))
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $60
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 + 1.5), 0.0, $00, $00, $06, $00, $00)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.1), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            createdoor(arg0, (arg0\Field3 - 2.75), (arg0\Field4 + 3.5), (arg0\Field5 + 2.875), 90.0, $00, $06, $06, $00, $00)
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 - (1.0 / 1.07113)), (arg0\Field4 + 4.3125), (arg0\Field5 + 2.46875), -90.0, $01)
            arg0\Field13[$01] = createlever(arg0, (arg0\Field3 - (1.0 / 1.07113)), (arg0\Field4 + 4.3125), (arg0\Field5 + 2.21875), -90.0, $01)
            arg0\Field13[$02] = createlever(arg0, (arg0\Field3 - (1.0 / 1.07113)), (arg0\Field4 + 4.3125), (arg0\Field5 + 1.96875), -90.0, $01)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 1.035156), (arg0\Field4 + 5.0), (arg0\Field5 + (1.0 / 2.438095)), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 45.0
            local2\Field9 = 45.0
            local7 = createitem("Note from Daniel", $00, (arg0\Field3 - (1.0 / 0.64)), (arg0\Field4 + 4.0625), (arg0\Field5 + (1.0 / 2.226087)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $63
            createdoor(arg0, (arg0\Field3 + 2.363281), arg0\Field4, (arg0\Field5 - (1.0 / 1.094017)), 0.0, (rand($06, $01) = $01), $04, $00, $00, $00)
            createdoor(arg0, (arg0\Field3 - 2.363281), arg0\Field4, (arg0\Field5 - (1.0 / 1.094017)), 0.0, $00, $04, $00, $00, $00)
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field7\Field6 = $63) Then
                        arg0\Field11[$00] = copyentity(local4\Field11[$00], arg0\Field2)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field11[$00] = $00) Then
                arg0\Field11[$00] = loadmesh_strict("GFX\Map\room3_ez_hb.b3d", arg0\Field2)
            EndIf
            arg0\Field12[$00] = $01
            entitypickmode(arg0\Field11[$00], $02, $01)
            entitytype(arg0\Field11[$00], $01, $00)
            entityalpha(arg0\Field11[$00], 0.0)
            local2 = createsecuritycam(arg0, (arg0\Field3 - 1.25), (arg0\Field4 + 1.5), (arg0\Field5 + 2.0), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 225.0
            local2\Field9 = 45.0
            local7 = createrandombattery((arg0\Field3 - 3.660156), (arg0\Field4 + 1.015625), (arg0\Field5 - 3.660156))
            entityparent(local7\Field2, arg0\Field2, $01)
            local27 = rand($05, $01)
            If (local27 > $03) Then
                local7 = createitem("Radio Transceiver", $45, (arg0\Field3 + 2.78125), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 3.113281), $00, $00, $00, 1.0, $00)
                local7\Field12 = rnd(0.0, 100.0)
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createitem("Cup", $2B, (arg0\Field3 + 3.4375), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 1.171875), $C8, $C8, $C8, 1.0, $00)
                local7\Field1 = "COFFEE"
                local7\Field0 = format(getlocalstring("items", "cupof"), getlocalstring("misc", "coffee"), "%s")
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createrandombattery((arg0\Field3 + 3.683594), (arg0\Field4 + (1.0 / 1.024)), (arg0\Field5 - 3.648438))
                entityparent(local7\Field2, arg0\Field2, $01)
            ElseIf (local27 > $01) Then
                local7 = createitem("S-NAV Navigator", $49, (arg0\Field3 + 2.78125), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 3.113281), $00, $00, $00, 1.0, $00)
                local7\Field12 = rnd(0.0, 100.0)
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createrandombattery((arg0\Field3 + 3.4375), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 1.171875))
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local7 = createitem("Quarter", $6A, (arg0\Field3 - (1.0 / 1.094017)), (arg0\Field4 + (1.0 / 8.533334)), (arg0\Field5 + 1.972656), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
        Case $64
            local7 = createrandombattery((arg0\Field3 - 0.515625), (arg0\Field4 - 1.4375), (arg0\Field5 - 2.570312))
            entityparent(local7\Field2, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local7 = createrandombattery((arg0\Field3 - 0.296875), (arg0\Field4 - 1.4375), (arg0\Field5 - 2.570312))
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local7 = createrandombattery((arg0\Field3 - 0.765625), (arg0\Field4 - 1.4375), (arg0\Field5 - 2.570312))
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            local7 = createitem("S-NAV Navigator", $49, (arg0\Field3 + (1.0 / 4.413793)), (arg0\Field4 - 1.96875), (arg0\Field5 - 2.570312), $00, $00, $00, 1.0, $00)
            local7\Field12 = rnd(100.0, 0.0)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $65
            local7 = createitem("Document SCP-970", $00, (arg0\Field3 + 3.75), (arg0\Field4 - 1.75), (arg0\Field5 + (1.0 / 1.01992)), $00, $00, $00, 1.0, $00)
            rotateentity(local7\Field2, 0.0, 0.0, 0.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            local7 = createitem("Gas Mask", $38, (arg0\Field3 + 3.726562), (arg0\Field4 - 1.96875), (arg0\Field5 + (1.0 / 1.089362)), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
        Case $66
            local2 = createsecuritycam(arg0, (arg0\Field3 - 1.25), (arg0\Field4 + 1.5), (arg0\Field5 + 2.0), 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 225.0
            local2\Field9 = 45.0
        Case $61
            local0 = createdoor(arg0, arg0\Field3, arg0\Field4, (arg0\Field5 - 1.789062), 0.0, $00, $00, $04, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.07), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.04), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 1.12), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.04), $01)
            local0 = createdoor(arg0, (arg0\Field3 - 2.875), arg0\Field4, (arg0\Field5 - 1.789062), 0.0, $00, $00, $00, $00, $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.04), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.04), $01)
            local0 = createdoor(arg0, (arg0\Field3 - (1.0 / 1.07563)), arg0\Field4, (arg0\Field5 - 2.875), -90.0, $00, $00, $00, $00, $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.04), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.04), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0, (arg0\Field3 + 0.96875), arg0\Field4, (arg0\Field5 - 2.875), 90.0, $00, $00, $04, $00, $00)
            local0\Field4 = $01
            local0\Field16 = $01
            local0\Field23 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0, (arg0\Field3 - 1.800781), arg0\Field4, (arg0\Field5 + 1.324219), 90.0, $01, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, (arg0\Field3 + 1.800781), arg0\Field4, (arg0\Field5 + 1.324219), 270.0, $01, $00, $00, $00, $00)
            local0\Field4 = $01
            local0\Field23 = $00
            For local25 = $00 To $01 Step $01
                freeentity(local0\Field3[local25])
                local0\Field3[local25] = $00
            Next
            arg0\Field14[$01] = local0
            arg0\Field13[$00] = createlever(arg0, (arg0\Field3 + 1.089844), (arg0\Field4 + 0.75), (arg0\Field5 + 0.640625), 0.0, $01)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], arg0\Field3, (arg0\Field4 + 0.5), (arg0\Field5 + 1.3125), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            createcustomcenter(arg0, arg0\Field3, (arg0\Field5 - 2.875))
        Case $62
            createdoor(arg0, (arg0\Field3 + 3.0), arg0\Field4, (arg0\Field5 + (1.0 / 1.094017)), 180.0, $01, $04, $00, $00, $00)
            arg0\Field11[$00] = loadmesh_strict("GFX\Map\room3_office_hb.b3d", arg0\Field2)
            arg0\Field12[$00] = $01
            entitypickmode(arg0\Field11[$00], $02, $01)
            entitytype(arg0\Field11[$00], $01, $00)
            entityalpha(arg0\Field11[$00], 0.0)
            local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 - 3.738281), (arg0\Field4 + 0.859375), (arg0\Field5 + 2.574219), $00, $00, $00, 1.0, $00)
            entityparent(local7\Field2, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 - 3.738281), (arg0\Field4 + (1.0 / 1.630573)), (arg0\Field5 + 3.457031), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 + 1.199219), (arg0\Field4 + 0.546875), (arg0\Field5 + 3.167969), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            local3 = createdecal($15, (arg0\Field3 + 0.921875), (arg0\Field4 + 0.005), (arg0\Field5 - 0.265625), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.5, 0.7), 1.0, $00, $01, $00, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
        Case $68
            createdoor(arg0, (arg0\Field3 + 2.363281), arg0\Field4, (arg0\Field5 - (1.0 / 1.094017)), 0.0, (rand($05, $01) = $01), $04, $00, $00, $00)
            createdoor(arg0, (arg0\Field3 + 2.363281), arg0\Field4, (arg0\Field5 + (1.0 / 1.094017)), 180.0, $00, $04, $00, $00, $00)
            createdoor(arg0, (arg0\Field3 - 2.363281), arg0\Field4, (arg0\Field5 - (1.0 / 1.094017)), 0.0, $00, $04, $00, $00, $00)
            createdoor(arg0, (arg0\Field3 - 2.363281), arg0\Field4, (arg0\Field5 + (1.0 / 1.094017)), 180.0, (rand($03, $01) = $01), $04, $00, $00, $00)
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field7\Field6 = $68) Then
                        arg0\Field11[$00] = copyentity(local4\Field11[$00], arg0\Field2)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field11[$00] = $00) Then
                arg0\Field11[$00] = loadmesh_strict("GFX\Map\room4_2_ez_hb.b3d", arg0\Field2)
            EndIf
            arg0\Field12[$00] = $01
            entitypickmode(arg0\Field11[$00], $02, $01)
            entitytype(arg0\Field11[$00], $01, $00)
            entityalpha(arg0\Field11[$00], 0.0)
            local2 = createsecuritycam(arg0, arg0\Field3, (arg0\Field4 + 1.5), arg0\Field5, 20.0, $00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
            local2\Field8 = 225.0
            local2\Field9 = 45.0
            local2\Field17 = $01
            local27 = rand($05, $01)
            If (local27 > $03) Then
                local7 = createitem("Radio Transceiver", $45, (arg0\Field3 + 2.78125), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 3.113281), $00, $00, $00, 1.0, $00)
                local7\Field12 = rnd(0.0, 100.0)
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createitem("Cup", $2B, (arg0\Field3 + 3.4375), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 1.171875), $C8, $C8, $C8, 1.0, $00)
                local7\Field1 = "COFFEE"
                local7\Field0 = format(getlocalstring("items", "cupof"), getlocalstring("misc", "coffee"), "%s")
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createrandombattery((arg0\Field3 + 3.683594), (arg0\Field4 + (1.0 / 1.024)), (arg0\Field5 - 3.648438))
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createitem(("Document SCP-" + getranddocument()), $00, (arg0\Field3 - 2.78125), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 3.113281), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 - 2.007812), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + 2.234375), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createrandombattery((arg0\Field3 - 3.660156), (arg0\Field4 + 1.015625), (arg0\Field5 - 3.660156))
                entityparent(local7\Field2, arg0\Field2, $01)
            ElseIf (local27 > $01) Then
                local7 = createitem("S-NAV Navigator", $49, (arg0\Field3 + 2.78125), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 3.113281), $00, $00, $00, 1.0, $00)
                local7\Field12 = rnd(0.0, 100.0)
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createitem("Empty Cup", $2C, (arg0\Field3 + 3.4375), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 1.171875), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createrandombattery((arg0\Field3 - 2.78125), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 - 3.113281))
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createitem("Quarter", $6A, (arg0\Field3 - 2.007812), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + 2.234375), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
                local7 = createitem("ReVision Eyedrops", $30, (arg0\Field3 - 3.660156), (arg0\Field4 + 1.015625), (arg0\Field5 - 3.660156), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local7 = createitem("Quarter", $6A, (arg0\Field3 - 2.289062), (arg0\Field4 + (1.0 / 8.533334)), (arg0\Field5 + 2.84375), $00, $00, $00, 1.0, $00)
                entityparent(local7\Field2, arg0\Field2, $01)
            EndIf
        Case $69
            local22 = loadtexture_strict("GFX\Map\Textures\rockmoss.jpg", $01, $00, $01)
            For local25 = $00 To $09 Step $01
                Select local25
                    Case $00
                        local12 = 5187.0
                        local14 = 2523.0
                        local29 = 180.0
                    Case $01
                        local12 = 5521.0
                        local14 = 1641.0
                        local29 = 180.0
                    Case $02
                        local12 = 9128.0
                        local14 = 2160.0
                        local29 = 180.0
                    Case $03
                        local12 = 8523.0
                        local14 = 1728.0
                        local29 = 180.0
                    Case $04
                        local12 = 9880.0
                        local14 = 1212.0
                        local29 = 180.0
                    Case $05
                        local12 = 5299.0
                        local14 = 360.0
                        local29 = 90.0
                    Case $06
                        local12 = 7807.0
                        local14 = 1259.0
                        local29 = 90.0
                    Case $07
                        local12 = 8196.0
                        local14 = 1404.0
                        local29 = 90.0
                    Case $08
                        local12 = 8143.0
                        local14 = 360.0
                        local29 = 90.0
                    Case $09
                        local12 = 9709.0
                        local14 = 888.0
                        local29 = 90.0
                End Select
                local3 = createdecal($00, (arg0\Field3 + (local12 * (1.0 / 256.0))), ((arg0\Field4 + 10.05469) + 0.05), ((arg0\Field5 + 32.0) + (local14 * (1.0 / 256.0))), 90.0, 0.0, 0.0, rnd(0.8, 1.0), 1.0, $00, $01, $00, $00, $00)
                local0 = createdoor(arg0, (arg0\Field3 + (local12 * (1.0 / 256.0))), (arg0\Field4 + 10.05469), ((arg0\Field5 + 32.0) + (local14 * (1.0 / 256.0))), local29, $00, $00, $09, $00, $00)
                entitytexture(local0\Field0, local22, $00, $00)
                If (local0\Field1 <> $00) Then
                    entitytexture(local0\Field1, local22, $00, $00)
                EndIf
                entitytexture(local0\Field2, local22, $00, $00)
            Next
            deletesingletextureentryfromcache(local22, $00)
            local22 = $00
            local0 = createdoor(arg0, arg0\Field3, (arg0\Field4 + 8.046875), ((arg0\Field5 + 32.0) - 4.0), 0.0, $00, $02, $00, $00, $00)
            local0\Field20 = $00
            arg0\Field14[$00] = local0
            local0 = createdoor(arg0, arg0\Field3, (arg0\Field4 + 8.0), ((arg0\Field5 + 32.0) + 4.0), 180.0, $00, $02, $00, $00, $00)
            local0\Field20 = $00
            arg0\Field14[$01] = local0
            local3 = createdecal($0D, (arg0\Field3 - 6.0), (arg0\Field4 + 0.02), ((arg0\Field5 + 2.375) + 32.0), 90.0, 0.0, 0.0, 0.8, 1.0, $01, $02, $00, $00, $00)
            local48 = loadrmesh("GFX\Map\dimension_106_2.rmesh", Null, $01)
            For local25 = $01 To $08 Step $01
                arg0\Field11[(local25 - $01)] = copyentity(local48, $00)
                local29 = ((Float (local25 - $01)) * 45.0)
                local32 = (sin(local29) * 2.0)
                local33 = (cos(local29) * 2.0)
                scaleentity(arg0\Field11[(local25 - $01)], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                entitytype(arg0\Field11[(local25 - $01)], $01, $00)
                entitypickmode(arg0\Field11[(local25 - $01)], $02, $01)
                rotateentity(arg0\Field11[(local25 - $01)], 0.0, (local29 - 90.0), 0.0, $00)
                positionentity(arg0\Field11[(local25 - $01)], (arg0\Field3 + local33), arg0\Field4, (arg0\Field5 + local32), $00)
                entityparent(arg0\Field11[(local25 - $01)], arg0\Field2, $01)
                If (local25 < $06) Then
                    local3 = createdecal((local25 + $07), (arg0\Field3 + (local33 * 2.0)), (arg0\Field4 + 0.02), (arg0\Field5 + (local32 * 2.0)), 90.0, (local29 - 90.0), 0.0, 0.5, 1.0, $01, $02, $00, $00, $00)
                EndIf
            Next
            freeentity(local48)
            local48 = $00
            arg0\Field11[$08] = loadrmesh("GFX\Map\dimension_106_3.rmesh", Null, $01)
            arg0\Field11[$09] = loadmesh_strict("GFX\Map\Props\dimension_106_pillar.b3d", $00)
            arg0\Field11[$0A] = copyentity(arg0\Field11[$09], $00)
            arg0\Field11[$0B] = loadrmesh("GFX\Map\dimension_106_4.rmesh", Null, $01)
            For local25 = $08 To $0B Step $01
                scaleentity(arg0\Field11[local25], ((((Float (local25 = $0A)) * 1.5) + (Float (local25 <> $0A))) * (1.0 / 256.0)), ((((Float (local25 = $0A)) * 2.0) + (Float (local25 <> $0A))) * (1.0 / 256.0)), ((((Float (local25 = $0A)) * 1.5) + (Float (local25 <> $0A))) * (1.0 / 256.0)), $00)
                entitytype(arg0\Field11[local25], $01, $00)
                entitypickmode(arg0\Field11[local25], $02, $01)
                positionentity(arg0\Field11[local25], arg0\Field3, arg0\Field4, ((arg0\Field5 + 32.0) + (32.0 * (Float (local25 = $0B)))), $01)
            Next
            For local25 = $0C To $10 Step $01
                arg0\Field11[local25] = createpivot(arg0\Field11[$0B])
                Select local25
                    Case $0C
                        positionentity(arg0\Field11[local25], arg0\Field3, (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + 64.0), $01)
                    Case $0D
                        positionentity(arg0\Field11[local25], (arg0\Field3 + 1.523438), (arg0\Field4 + (1.0 / 1.28)), ((arg0\Field5 + 64.0) + 1.0625), $01)
                    Case $0E
                        positionentity(arg0\Field11[local25], (arg0\Field3 + 3.273438), (arg0\Field4 + (1.0 / 1.28)), ((arg0\Field5 + 64.0) - 2.152344), $01)
                    Case $0F
                        positionentity(arg0\Field11[local25], (arg0\Field3 - (1.0 / 1.841727)), (arg0\Field4 + (1.0 / 1.28)), ((arg0\Field5 + 64.0) + 4.691406), $01)
                    Case $10
                        positionentity(arg0\Field11[local25], (arg0\Field3 - 4.835938), (arg0\Field4 - 6.5), ((arg0\Field5 + 64.0) + 1.488281), $01)
                End Select
            Next
            arg0\Field21[$00] = loadtexture_strict("GFX\NPCs\pd_plane.png", $03, $01, $00)
            arg0\Field21[$01] = loadtexture_strict("GFX\NPCs\pd_plane_eye.png", $03, $01, $00)
            arg0\Field11[$11] = createsprite($00)
            arg0\Field12[$11] = $01
            local22 = loadtexture_strict("GFX\NPCs\scp_106_eyes.png", $01, $00, $00)
            entitytexture(arg0\Field11[$11], local22, $00, $00)
            deletesingletextureentryfromcache(local22, $00)
            local22 = $00
            positionentity(arg0\Field11[$11], entityx(arg0\Field11[$08], $01), (arg0\Field4 + 5.375), (entityz(arg0\Field11[$08], $01) - 11.125), $00)
            rotateentity(arg0\Field11[$11], 0.0, 180.0, 0.0, $00)
            scalesprite(arg0\Field11[$11], 0.03, 0.03)
            entityblend(arg0\Field11[$11], $03)
            entityfx(arg0\Field11[$11], $09)
            spriteviewmode(arg0\Field11[$11], $02)
            arg0\Field11[$12] = loadmesh_strict("GFX\Map\Props\throne_wall.b3d", $00)
            arg0\Field12[$12] = $01
            positionentity(arg0\Field11[$12], entityx(arg0\Field11[$08], $01), arg0\Field4, (entityz(arg0\Field11[$08], $01) - 3.376953), $00)
            scaleentity(arg0\Field11[$12], (1.0 / 522.24), (1.0 / 256.0), (1.0 / 256.0), $00)
            entitypickmode(arg0\Field11[$12], $02, $01)
            entitytype(arg0\Field11[$12], $01, $00)
            entityparent(arg0\Field11[$12], arg0\Field2, $01)
            arg0\Field11[$13] = createsprite($00)
            arg0\Field12[$13] = $01
            scalesprite(arg0\Field11[$13], 8.0, 8.0)
            entitytexture(arg0\Field11[$13], arg0\Field21[$00], $00, $00)
            entityorder(arg0\Field11[$13], $64)
            entityblend(arg0\Field11[$13], $02)
            entityfx(arg0\Field11[$13], $09)
            spriteviewmode(arg0\Field11[$13], $02)
            positionentity(arg0\Field11[$13], (entityx(arg0\Field11[$08], $01) - 1000.0), 16.0, 0.0, $01)
            arg0\Field11[$14] = loadmesh_strict("GFX\Map\dimension_106_terrain.b3d", $00)
            arg0\Field12[$14] = $01
            local22 = loadtexture_strict("GFX\Map\Textures\rockmoss.jpg", $01, $00, $01)
            entitytexture(arg0\Field11[$14], local22, $00, $00)
            deletesingletextureentryfromcache(local22, $00)
            local22 = $00
            scaleentity(arg0\Field11[$14], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            entitytype(arg0\Field11[$14], $01, $00)
            positionentity(arg0\Field11[$14], arg0\Field3, ((arg0\Field4 + 16.0) + 11.5), (arg0\Field5 + 32.0), $01)
            For local25 = $11 To $14 Step $01
                hideentity(arg0\Field11[local25])
            Next
            arg0\Field11[$15] = createpivot($00)
            positionentity(arg0\Field11[$15], (arg0\Field3 + 28.16797), (arg0\Field4 + 10.35156), ((arg0\Field5 + 32.0) + 6.117188), $00)
            entityparent(arg0\Field11[$15], arg0\Field2, $01)
            arg0\Field11[$16] = createpivot($00)
            positionentity(arg0\Field11[$16], (arg0\Field3 + 20.55078), (arg0\Field4 + 10.35156), ((arg0\Field5 + 32.0) + 10.54688), $00)
            entityparent(arg0\Field11[$16], arg0\Field2, $01)
            arg0\Field11[$17] = createpivot($00)
            positionentity(arg0\Field11[$17], (arg0\Field3 + 26.69922), (arg0\Field4 + 10.35156), ((arg0\Field5 + 32.0) + 9.289062), $00)
            entityparent(arg0\Field11[$17], arg0\Field2, $01)
            arg0\Field11[$18] = createpivot($00)
            positionentity(arg0\Field11[$18], (arg0\Field3 + 30.95703), (arg0\Field4 + 10.35156), ((arg0\Field5 + 32.0) + (1.0 / 1.273632)), $00)
            entityparent(arg0\Field11[$18], arg0\Field2, $01)
            arg0\Field11[$19] = createpivot($00)
            positionentity(arg0\Field11[$19], (arg0\Field3 + 32.73438), (arg0\Field4 + 10.35156), ((arg0\Field5 + 32.0) + 8.988281), $00)
            entityparent(arg0\Field11[$19], arg0\Field2, $01)
            local7 = createitem("Burnt Note", $00, arg0\Field3, (arg0\Field4 + 0.5), (arg0\Field5 + 3.5), $00, $00, $00, 1.0, $00)
            local7 = createitem("George Maynard's Badge", $04, (arg0\Field3 - 5.078125), (arg0\Field4 + 0.5), (arg0\Field5 + 33.98438), $00, $00, $00, 1.0, $00)
        Case $6A
            arg0\Field11[$10] = createpivot($00)
            positionentity(arg0\Field11[$10], (arg0\Field3 + (1.0 / 1.24878)), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + 8.933594), $00)
            entityparent(arg0\Field11[$10], arg0\Field2, $01)
            arg0\Field11[$11] = loadmesh_strict("GFX\Map\dimension1499\1499object0_cull.b3d", arg0\Field2)
            arg0\Field12[$11] = $01
            entitytype(arg0\Field11[$11], $01, $00)
            entityalpha(arg0\Field11[$11], 0.0)
    End Select
    For local50 = Each tempscreens
        If (local50\Field4 = arg0\Field7) Then
            createscreen(arg0, (arg0\Field3 + local50\Field1), (arg0\Field4 + local50\Field2), (arg0\Field5 + local50\Field3), local50\Field0)
        EndIf
    Next
    For local51 = Each tempwaypoints
        If (local51\Field3 = arg0\Field7) Then
            createwaypoint(Null, arg0, (arg0\Field3 + local51\Field0), (arg0\Field4 + local51\Field1), (arg0\Field5 + local51\Field2))
        EndIf
    Next
    For local52 = Each templights
        If (local52\Field0 = arg0\Field7) Then
            local11 = addlight(arg0, (arg0\Field3 + local52\Field2), (arg0\Field4 + local52\Field3), (arg0\Field5 + local52\Field4), local52\Field1, local52\Field5, local52\Field6, local52\Field7, local52\Field8, local52\Field13)
            If (local52\Field1 = $03) Then
                rotateentity(local11\Field0, local52\Field9, local52\Field10, 0.0, $00)
            EndIf
        EndIf
    Next
    For local53 = Each tempprops
        If (local53\Field13 = arg0\Field7) Then
            createprop(arg0, local53\Field0, (arg0\Field3 + local53\Field1), (arg0\Field4 + local53\Field2), (arg0\Field5 + local53\Field3), local53\Field4, local53\Field5, local53\Field6, local53\Field7, local53\Field8, local53\Field9, local53\Field10, local53\Field11, local53\Field12)
        EndIf
    Next
    For local54 = Each tempsoundemitters
        If (local54\Field5 = arg0\Field7) Then
            createsoundemitter(arg0, local54\Field3, (arg0\Field3 + local54\Field0), (arg0\Field4 + local54\Field1), (arg0\Field5 + local54\Field2), local54\Field4)
        EndIf
    Next
    catcherrors((("Uncaught: FillRoom(Room ID: " + (Str arg0\Field7\Field6)) + ")"))
    Return $00
End Function
