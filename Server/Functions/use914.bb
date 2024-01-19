Function use914%(arg0.items, arg1$, arg2#, arg3#, arg4#)
    Local local0.items
    Local local4.decals
    Local local16.npcs
    Local local22.items
    Local local32%
    Local local33%
    Local local39.items
    Local local40.items
    Local local41.items
    Local local54%
    refineditems = (refineditems + $01)
    If (getscripts() <> 0) Then
        public_inqueue($45, $00)
        public_addparam($00, arg1, $03)
        public_addparam($00, (Str arg2), $02)
        public_addparam($00, (Str arg3), $02)
        public_addparam($00, (Str arg4), $02)
        public_addparam($00, (Str arg0\Field18), $01)
        public_addparam($00, "0", $01)
        callback($00)
    EndIf
    If (se_return_value\Field8 <> 0) Then
        Return $00
    EndIf
    Select arg0\Field3\Field1
        Case "Grenade"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("Smoke grenade", "grenadesmoke", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "1:1"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    If (rand($04, $01) = $01) Then
                        local0 = createitem("Rocket Launcher", "rpg", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    Else
                        local0 = createitem("Flashbang", "grenadeflashbang", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    EndIf
            End Select
        Case "Smoke grenade"
            Select arg1
                Case "rough","course"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                    removeitem(arg0, $01)
                Case "1:1"
                    local0 = createitem("Flashbang", "grenadeflashbang", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "fine","very fine"
                    If (rand($06, $01) = $01) Then
                        local0 = createitem("Micro-HID", "microhid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    Else
                        local0 = createitem("Grenade", "grenade", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    EndIf
            End Select
        Case "Flashbang"
            Select arg1
                Case "rough","course"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                    removeitem(arg0, $01)
                Case "1:1"
                    local0 = createitem("Smoke grenade", "grenadesmoke", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "fine","very fine"
                    If (rand($06, $01) = $01) Then
                        local0 = createitem("Micro-HID", "microhid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    Else
                        local0 = createitem("Grenade", "grenade", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    EndIf
            End Select
        Case "Minigun"
            Select arg1
                Case "rough","course"
                    local0 = createitem("HK-G36", "hkg36", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "1:1"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
            End Select
        Case "HK-G36"
            Select arg1
                Case "rough","course"
                    local0 = createitem("FN P90", "p90", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "1:"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    If (rand($04, $01) = $01) Then
                        local0 = createitem("Minigun", "minigun", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    Else
                        local0 = createitem("HK-G36", "hkg36", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    EndIf
            End Select
        Case "FN P90"
            Select arg1
                Case "rough","course"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Desert Eagle", "deagle", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    Else
                        local0 = createitem("SPAS-12", "spas12", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    EndIf
                Case "1:"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Combat knife", "knife", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    Else
                        local0 = createitem("HK-G36", "hkg36", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    EndIf
            End Select
        Case "Desert Eagle","SPAS-12"
            Select arg1
                Case "rough","course"
                    local0 = createitem("M4A4", "m4a4", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "1:"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    local0 = createitem("FN P90", "p90", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
            End Select
        Case "M4A4"
            Select arg1
                Case "rough","course"
                    local0 = createitem("MP5-SD", "mp5sd", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "1:"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Desert Eagle", "deagle", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    Else
                        local0 = createitem("SPAS-12", "spas12", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    EndIf
            End Select
        Case "MP5-SD"
            Select arg1
                Case "rough","course"
                    local0 = createitem("USP Tactical", "usp", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "1:"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    local0 = createitem("M4A4", "m4a4", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
            End Select
        Case "USP Tactical"
            Select arg1
                Case "rough","course"
                    local0 = createitem("Combat knife", "knife", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "1:"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    local0 = createitem("M4A4", "m4a4", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
            End Select
        Case "Combat knife"
            Select arg1
                Case "rough","course"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                    removeitem(arg0, $01)
                Case "1:"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    local0 = createitem("USP Tactical", "usp", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
            End Select
        Case "Gas Mask","Heavy Gas Mask"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                    removeitem(arg0, $01)
                Case "1:1"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    local0 = createitem("Gas Mask", "supergasmask", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
            End Select
        Case "Cooked Chicken"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                    removeitem(arg0, $01)
                Case "1:1"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    local16 = createnpc($04, arg2, arg3, arg4)
                    local16\Field9 = 1.0
                    removeitem(arg0, $01)
            End Select
        Case "SCP-1499"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                    removeitem(arg0, $01)
                Case "1:1"
                    local0 = createitem("Gas Mask", "gasmask", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "fine"
                    local0 = createitem("SCP-1499", "super1499", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "very fine"
                    local16 = createnpc($14, arg2, arg3, arg4)
                    local16\Field78 = $01
                    local16\Field9 = 1.0
                    local16\Field16 = loadsound_strict("SFX\SCP\1499\Triggered.ogg")
                    local16\Field17 = playsound2(local16\Field16, camera, local16\Field4, 20.0, 1.0)
                    local16\Field11 = 1.0
                    removeitem(arg0, $01)
            End Select
        Case "Ballistic Vest"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                    removeitem(arg0, $01)
                Case "1:1"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine"
                    local0 = createitem("Heavy Ballistic Vest", "finevest", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "very fine"
                    local0 = createitem("Bulky Ballistic Vest", "veryfinevest", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
            End Select
        Case "Cowbell"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.2
                    entityalpha(local4\Field0, 0.8)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                    removeitem(arg0, $01)
                Case "1:1","fine","very fine"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
            End Select
        Case "Night Vision Goggles"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                    removeitem(arg0, $01)
                Case "1:1"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine"
                    local0 = createitem("Night Vision Goggles", "finenvgoggles", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "very fine"
                    local0 = createitem("Night Vision Goggles", "supernv", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    local0\Field13 = 1000.0
                    removeitem(arg0, $01)
            End Select
        Case "Metal Panel","SCP-148 Ingot"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("SCP-148 Ingot", "scp148ingot", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "1:1","fine","very fine"
                    local0 = Null
                    For local22 = Each items
                        If ((((local22 <> arg0) And (local22\Field1 <> $00)) And (local22\Field15 = $00)) <> 0) Then
                            If ((180.0 * roomscale) > distance(entityx(local22\Field1, $01), entityz(local22\Field1, $01), entityx(arg0\Field1, $01), entityz(arg0\Field1, $01))) Then
                                local0 = local22
                                Exit
                            ElseIf ((180.0 * roomscale) > distance(entityx(local22\Field1, $01), entityz(local22\Field1, $01), arg2, arg4)) Then
                                local0 = local22
                                Exit
                            EndIf
                        EndIf
                    Next
                    If (local0 <> Null) Then
                        Select local0\Field3\Field2
                            Case "gasmask","supergasmask"
                                removeitem(local0, $01)
                                removeitem(arg0, $01)
                                local0 = createitem("Heavy Gas Mask", "gasmask3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            Case "vest"
                                removeitem(local0, $01)
                                removeitem(arg0, $01)
                                local0 = createitem("Heavy Ballistic Vest", "finevest", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            Case "hazmatsuit","hazmatsuit2"
                                removeitem(local0, $01)
                                removeitem(arg0, $01)
                                local0 = createitem("Heavy Hazmat Suit", "hazmatsuit3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        End Select
                    ElseIf (arg0\Field3\Field1 = "SCP-148 Ingot") Then
                        local0 = createitem("Metal Panel", "scp148", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        removeitem(arg0, $01)
                    Else
                        positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                        resetentity(arg0\Field1)
                    EndIf
            End Select
        Case "Severed Hand","Black Severed Hand"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($03, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1","fine","very fine"
                    If (arg0\Field3\Field1 = "Severed Hand") Then
                        local0 = createitem("Black Severed Hand", "hand2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    Else
                        local0 = createitem("Severed Hand", "hand", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    EndIf
            End Select
            removeitem(arg0, $01)
        Case "First Aid Kit","Blue First Aid Kit"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Blue First Aid Kit", "firstaid2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    Else
                        local0 = createitem("First Aid Kit", "firstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    EndIf
                Case "fine"
                    local0 = createitem("Small First Aid Kit", "finefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "very fine"
                    local0 = createitem("Strange Bottle", "veryfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
            End Select
            removeitem(arg0, $01)
        Case "Level 1 Key Card","Level 2 Key Card","Level 3 Key Card","Level 4 Key Card","Level 5 Key Card","Key Card"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.07
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "fine"
                    Select arg0\Field3\Field1
                        Case "Level 1 Key Card"
                            Select selecteddifficulty\Field5
                                Case $00
                                    local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                Case $01
                                    If (rand($05, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                                Case $02
                                    If (rand($04, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                            End Select
                        Case "Level 2 Key Card"
                            Select selecteddifficulty\Field5
                                Case $00
                                    local0 = createitem("Level 3 Key Card", "key3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                Case $01
                                    If (rand($04, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Level 3 Key Card", "key3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                                Case $02
                                    If (rand($03, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Level 3 Key Card", "key3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                            End Select
                        Case "Level 3 Key Card"
                            Select selecteddifficulty\Field5
                                Case $00
                                    If (rand($0A, $01) = $01) Then
                                        local0 = createitem("Level 4 Key Card", "key4", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                                Case $01
                                    If (rand($0F, $01) = $01) Then
                                        local0 = createitem("Level 4 Key Card", "key4", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                                Case $02
                                    If (rand($14, $01) = $01) Then
                                        local0 = createitem("Level 4 Key Card", "key4", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                            End Select
                        Case "Level 4 Key Card"
                            Select selecteddifficulty\Field5
                                Case $00
                                    local0 = createitem("Level 5 Key Card", "key5", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                Case $01
                                    If (rand($04, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Level 5 Key Card", "key5", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                                Case $02
                                    If (rand($03, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Level 5 Key Card", "key5", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                            End Select
                        Case "Level 5 Key Card"
                            local32 = $00
                            For local33 = $00 To $24 Step $01
                                If (achievements(local33) = $01) Then
                                    local32 = (local32 + $01)
                                EndIf
                            Next
                            debuglog((Str local32))
                            Select selecteddifficulty\Field5
                                Case $00
                                    If (rand($00, ($6C - ((local32 - $01) * $03))) = $00) Then
                                        local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                                Case $01
                                    If (rand($00, ($90 - ((local32 - $01) * $03))) = $00) Then
                                        local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                                Case $02
                                    If (rand($00, ($B4 - ((local32 - $01) * $03))) = $00) Then
                                        local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    Else
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                    EndIf
                            End Select
                    End Select
                Case "very fine"
                    local32 = $00
                    For local33 = $00 To $24 Step $01
                        If (achievements(local33) = $01) Then
                            local32 = (local32 + $01)
                        EndIf
                    Next
                    debuglog((Str local32))
                    Select selecteddifficulty\Field5
                        Case $00
                            If (rand($00, ($6C - ((local32 - $01) * $03))) = $00) Then
                                local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            Else
                                local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            EndIf
                        Case $01
                            If (rand($00, ($90 - ((local32 - $01) * $03))) = $00) Then
                                local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            Else
                                local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            EndIf
                        Case $02
                            If (rand($00, ($B4 - ((local32 - $01) * $03))) = $00) Then
                                local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            Else
                                local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            EndIf
                    End Select
            End Select
            removeitem(arg0, $01)
        Case "Key Card Omni"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.07
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    Else
                        local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    EndIf
                Case "fine","very fine"
                    local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
            End Select
            removeitem(arg0, $01)
        Case "Playing Card","Coin","Quarter"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.07
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("Level 1 Key Card", "key1", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "fine","very fine"
                    local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
            End Select
            removeitem(arg0, $01)
        Case "Mastercard"
            Select arg1
                Case "rough"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.07
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "coarse"
                    local0 = createitem("Quarter", "25ct", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    local39 = createitem("Quarter", "25ct", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    local40 = createitem("Quarter", "25ct", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    local41 = createitem("Quarter", "25ct", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "1:1"
                    local0 = createitem("Level 1 Key Card", "key1", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "fine","very fine"
                    local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
            End Select
            removeitem(arg0, $01)
        Case "S-NAV 300 Navigator","S-NAV 310 Navigator","S-NAV Navigator","S-NAV Navigator Ultimate"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("Electronical components", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "1:1"
                    local0 = createitem("S-NAV Navigator", "nav", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    local0\Field13 = 100.0
                Case "fine"
                    local0 = createitem("S-NAV 310 Navigator", "nav", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    local0\Field13 = 100.0
                Case "very fine"
                    local0 = createitem("S-NAV Navigator Ultimate", "nav", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    local0\Field13 = 101.0
            End Select
            removeitem(arg0, $01)
        Case "Radio Transceiver"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("Electronical components", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "1:1"
                    local0 = createitem("Radio Transceiver", "18vradio", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    local0\Field13 = 100.0
                Case "fine"
                    local0 = createitem("Radio Transceiver", "fineradio", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    local0\Field13 = 101.0
                Case "very fine"
                    local0 = createitem("Radio Transceiver", "veryfineradio", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    local0\Field13 = 101.0
            End Select
            removeitem(arg0, $01)
        Case "SCP-513"
            Select arg1
                Case "rough","coarse"
                    playsound_strict(loadtempsound("SFX\SCP\513\914Refine.ogg"))
                    For local16 = Each npcs
                        If (local16\Field5 = $0C) Then
                            removenpc(local16, $01)
                        EndIf
                    Next
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.2
                    entityalpha(local4\Field0, 0.8)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1","fine","very fine"
                    local0 = createitem("SCP-513", "scp513", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
            End Select
            removeitem(arg0, $01)
        Case "Some SCP-420-J","Cigarette"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.2
                    entityalpha(local4\Field0, 0.8)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("Cigarette", "cigarette", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0), $00, $00, $00, 1.0, $00, $01)
                Case "fine"
                    local0 = createitem("Joint", "420s", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0), $00, $00, $00, 1.0, $00, $01)
                Case "very fine"
                    local0 = createitem("Smelly Joint", "420s", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0), $00, $00, $00, 1.0, $00, $01)
            End Select
            removeitem(arg0, $01)
        Case "9V Battery","18V Battery","Strange Battery"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.2
                    entityalpha(local4\Field0, 0.8)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("18V Battery", "18vbat", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "fine"
                    local0 = createitem("Strange Battery", "killbat", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "very fine"
                    local0 = createitem("Strange Battery", "killbat", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
            End Select
            removeitem(arg0, $01)
        Case "ReVision Eyedrops","RedVision Eyedrops","Eyedrops"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.2
                    entityalpha(local4\Field0, 0.8)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("RedVision Eyedrops", "eyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "fine"
                    local0 = createitem("Eyedrops", "fineeyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "very fine"
                    local0 = createitem("Eyedrops", "supereyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
            End Select
            removeitem(arg0, $01)
        Case "Hazmat Suit"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.2
                    entityalpha(local4\Field0, 0.8)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("Hazmat Suit", "hazmatsuit", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "fine"
                    local0 = createitem("Hazmat Suit", "hazmatsuit2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                Case "very fine"
                    local0 = createitem("Hazmat Suit", "hazmatsuit2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
            End Select
            removeitem(arg0, $01)
        Case "Syringe"
            Select arg0\Field3\Field2
                Case "syringe"
                    Select arg1
                        Case "rough","coarse"
                            local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                            local4\Field2 = 0.07
                            scalesprite(local4\Field0, local4\Field2, local4\Field2)
                        Case "1:1"
                            local0 = createitem("Small First Aid Kit", "finefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        Case "fine"
                            local0 = createitem("Syringe", "finesyringe", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        Case "very fine"
                            local0 = createitem("Syringe", "veryfinesyringe", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    End Select
                Case "finesyringe"
                    Select arg1
                        Case "rough"
                            local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                            local4\Field2 = 0.07
                            scalesprite(local4\Field0, local4\Field2, local4\Field2)
                        Case "coarse"
                            local0 = createitem("First Aid Kit", "firstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        Case "1:1"
                            local0 = createitem("Blue First Aid Kit", "firstaid2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        Case "fine","very fine"
                            local0 = createitem("Syringe", "veryfinesyringe", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    End Select
                Case "veryfinesyringe"
                    Select arg1
                        Case "rough","coarse","1:1","fine"
                            local0 = createitem("Electronical components", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                        Case "very fine"
                            local16 = createnpc($15, arg2, arg3, arg4)
                            local16\Field78 = $01
                            local16\Field9 = 2.0
                    End Select
            End Select
            removeitem(arg0, $01)
        Case "SCP-500-01","Upgraded pill","Pill"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.2
                    entityalpha(local4\Field0, 0.8)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("Pill", "pill", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
                Case "fine"
                    local54 = $00
                    For local39 = Each items
                        If (local39\Field3\Field2 = "scp427") Then
                            local54 = $01
                            Exit
                        EndIf
                    Next
                    If (local54 = $00) Then
                        local0 = createitem("SCP-427", "scp427", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    Else
                        local0 = createitem("Upgraded pill", "scp500death", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    EndIf
                    removeitem(arg0, $01)
                Case "very fine"
                    local0 = createitem("Upgraded pill", "scp500death", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    removeitem(arg0, $01)
            End Select
        Default
            Select arg0\Field3\Field2
                Case "cup"
                    Select arg1
                        Case "rough","coarse"
                            local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                            local4\Field2 = 0.2
                            entityalpha(local4\Field0, 0.8)
                            scalesprite(local4\Field0, local4\Field2, local4\Field2)
                        Case "1:1"
                            local0 = createitem("cup", "cup", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            local0\Field0 = arg0\Field0
                            local0\Field5 = ($FF - arg0\Field5)
                            local0\Field6 = ($FF - arg0\Field6)
                            local0\Field7 = ($FF - arg0\Field7)
                        Case "fine"
                            local0 = createitem("cup", "cup", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            local0\Field0 = arg0\Field0
                            local0\Field13 = 1.0
                            local0\Field5 = (Int min(((Float arg0\Field5) * rnd(0.9, 1.1)), 255.0))
                            local0\Field6 = (Int min(((Float arg0\Field6) * rnd(0.9, 1.1)), 255.0))
                            local0\Field7 = (Int min(((Float arg0\Field7) * rnd(0.9, 1.1)), 255.0))
                        Case "very fine"
                            local0 = createitem("cup", "cup", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            local0\Field0 = arg0\Field0
                            local0\Field13 = max((local0\Field13 * 2.0), 2.0)
                            local0\Field5 = (Int min(((Float arg0\Field5) * rnd(0.5, 1.5)), 255.0))
                            local0\Field6 = (Int min(((Float arg0\Field6) * rnd(0.5, 1.5)), 255.0))
                            local0\Field7 = (Int min(((Float arg0\Field7) * rnd(0.5, 1.5)), 255.0))
                            If (rand($05, $01) = $01) Then
                                explosiontimer = 135.0
                            EndIf
                    End Select
                    removeitem(arg0, $01)
                Case "paper"
                    Select arg1
                        Case "rough","coarse"
                            local4 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                            local4\Field2 = 0.12
                            scalesprite(local4\Field0, local4\Field2, local4\Field2)
                        Case "1:1"
                            Select rand($06, $01)
                                Case $01
                                    local0 = createitem("Document SCP-106", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                Case $02
                                    local0 = createitem("Document SCP-079", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                Case $03
                                    local0 = createitem("Document SCP-173", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                Case $04
                                    local0 = createitem("Document SCP-895", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                Case $05
                                    local0 = createitem("Document SCP-682", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                                Case $06
                                    local0 = createitem("Document SCP-860", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                            End Select
                        Case "fine","very fine"
                            local0 = createitem("Origami", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00, $01)
                    End Select
                    removeitem(arg0, $01)
                Default
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
            End Select
    End Select
    If (local4 <> Null) Then
        mp_writedecal(local4, $01, $01)
    EndIf
    If (local22 <> Null) Then
        local22\Field22 = $00
        local22\Field15 = $00
    EndIf
    If (local0 <> Null) Then
        local0\Field22 = $00
        local0\Field15 = $00
    EndIf
    Return $00
End Function
