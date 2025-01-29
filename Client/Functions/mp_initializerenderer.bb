Function mp_initializerenderer%()
    Local local0.mp_modelmeshpreset
    Local local1%
    Local local2.mp_attachmodelpreset
    loadspritefont("Tahoma", ("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Tahoma", "File", "", $01)), 64.0, 1.0)
    loadspritefont("Icons", ("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Icons", "File", "", $01)), 64.0, 1.0)
    createplayermodelmesh($01, "GFX\NPCs\class_d.b3d", $01)
    createplayermodeltexture($01, "GFX\NPCs\class_d.png", $01)
    createplayermodeltexture($02, "GFX\NPCs\class_d(2).png", $01)
    createplayermodeltexture($03, "GFX\NPCs\D_9341.png", $01)
    createplayermodeltexture($07, "GFX\NPCs\Maynard.png", $01)
    local0 = getplayermodelmeshpreset($01)
    local0\Field7 = $28
    local0\Field10 = -0.3
    local0\Field9 = 180.0
    local0\Field1 = "Bip01_Spine1"
    local0\Field0 = "Bip01_Head"
    local0\Field3 = "Bip01_L_Forearm"
    local0\Field2 = "Bip01_L_Finger0"
    local0\Field8 = $01
    local0\Field6 = $46
    local0\Field4 = $1E
    local0\Field5 = $3C
    local0\Field12 = (0.51 / meshwidth(getplayermodelmesh($01)))
    local0\Field11 = 0.3
    local0\Field14 = 0.0
    local0\Field15 = 70.0
    local0\Field16 = 10.0
    local0\Field17 = -0.03
    local0\Field18 = 0.015
    local0\Field19 = 0.0
    local0\Field20 = -60.0
    local0\Field21 = -45.0
    local0\Field22 = 0.0
    local0\Field23[$01] = packtwovalues($D2, $EB)
    local0\Field24[$01] = 0.1
    local0\Field23[$02] = packtwovalues($EC, $104)
    local0\Field24[$02] = 0.33
    local0\Field25[$02] = 45.0
    local0\Field23[$03] = packtwovalues($12D, $13F)
    local0\Field24[$03] = 0.33
    local0\Field25[$03] = 30.0
    local0\Field23[$04] = packtwovalues($165, $17D)
    local0\Field24[$04] = 0.1
    local0\Field23[$05] = packtwovalues($17E, $196)
    local0\Field24[$05] = 0.3
    local0\Field25[$05] = 45.0
    local0\Field23[$06] = packtwovalues($C1, $C5)
    local0\Field24[$06] = 0.025
    local0\Field23[$07] = packtwovalues($C7, $D1)
    local0\Field24[$07] = 0.33
    local0\Field25[$07] = 35.0
    local0\Field23[$08] = packtwovalues($322, $336)
    local0\Field24[$08] = 0.23
    local0\Field23[$09] = packtwovalues($30C, $321)
    local0\Field24[$09] = 0.33
    local0\Field28[$08] = $01
    local0\Field28[$09] = $01
    local0\Field26[$00] = packtwovalues($01, $14)
    local0\Field27[$00] = 0.4
    local0\Field26[$01] = packtwovalues($29, $3C)
    local0\Field27[$01] = 0.4
    local0\Field26[$02] = packtwovalues($2A6, $2C7)
    local0\Field27[$02] = 0.4
    local0\Field26[$03] = packtwovalues($2C8, $30B)
    local0\Field27[$03] = 0.4
    createplayermodelmesh($03, "GFX\NPCs\class_d.b3d", $01)
    createplayermodeltexture($05, "GFX\NPCs\sq.png", $01)
    local0 = getplayermodelmeshpreset($03)
    local0\Field7 = $28
    local0\Field10 = -0.3
    local0\Field9 = 180.0
    local0\Field1 = "Bip01_Spine1"
    local0\Field0 = "Bip01_Head"
    local0\Field3 = "Bip01_L_Forearm"
    local0\Field2 = "Bip01_L_Finger0"
    local0\Field8 = $01
    local0\Field6 = $46
    local0\Field4 = $1E
    local0\Field5 = $3C
    local0\Field12 = ((0.51 / meshwidth(getplayermodelmesh($03))) * 1.04)
    local0\Field11 = 0.3
    local0\Field14 = 0.0
    local0\Field15 = 70.0
    local0\Field16 = 10.0
    local0\Field17 = -0.03
    local0\Field18 = 0.015
    local0\Field19 = 0.0
    local0\Field20 = -60.0
    local0\Field21 = -45.0
    local0\Field22 = 0.0
    local0\Field23[$01] = packtwovalues($D2, $EB)
    local0\Field24[$01] = 0.1
    local0\Field23[$02] = packtwovalues($EC, $104)
    local0\Field24[$02] = 0.33
    local0\Field25[$02] = 45.0
    local0\Field23[$03] = packtwovalues($12D, $13F)
    local0\Field24[$03] = 0.33
    local0\Field25[$03] = 30.0
    local0\Field23[$04] = packtwovalues($165, $17D)
    local0\Field24[$04] = 0.1
    local0\Field23[$05] = packtwovalues($17E, $196)
    local0\Field24[$05] = 0.3
    local0\Field25[$05] = 45.0
    local0\Field23[$06] = packtwovalues($C1, $C5)
    local0\Field24[$06] = 0.025
    local0\Field23[$07] = packtwovalues($C7, $D1)
    local0\Field24[$07] = 0.33
    local0\Field25[$07] = 35.0
    local0\Field23[$08] = packtwovalues($322, $336)
    local0\Field24[$08] = 0.23
    local0\Field23[$09] = packtwovalues($30D, $321)
    local0\Field24[$09] = 0.33
    local0\Field28[$08] = $01
    local0\Field28[$09] = $01
    local0\Field26[$00] = packtwovalues($01, $14)
    local0\Field27[$00] = 0.4
    local0\Field26[$01] = packtwovalues($29, $3C)
    local0\Field27[$01] = 0.4
    local0\Field26[$02] = packtwovalues($2A6, $2C7)
    local0\Field27[$02] = 0.4
    local0\Field26[$03] = packtwovalues($2C8, $30B)
    local0\Field27[$03] = 0.4
    createplayermodelmesh($04, "GFX\NPCs\class_d_2.b3d", $01)
    createplayermodeltexture($06, "GFX\NPCs\muscles.png", $01)
    local0 = getplayermodelmeshpreset($04)
    local0\Field7 = $28
    local0\Field10 = -0.3
    local0\Field9 = 0.0
    local0\Field1 = "Bip01_Spine1"
    local0\Field0 = "Bip01_Head"
    local0\Field3 = "Bip01_L_Forearm"
    local0\Field2 = "Bip01_L_Finger0"
    local0\Field8 = $01
    local0\Field6 = $46
    local0\Field4 = $1E
    local0\Field5 = $3C
    local0\Field12 = 0.501398
    local0\Field11 = 0.3
    local0\Field14 = 0.0
    local0\Field15 = 70.0
    local0\Field16 = 10.0
    local0\Field17 = -0.03
    local0\Field18 = 0.015
    local0\Field19 = 0.0
    local0\Field20 = -60.0
    local0\Field21 = -45.0
    local0\Field22 = 0.0
    local0\Field23[$01] = packtwovalues($D2, $EB)
    local0\Field24[$01] = 0.1
    local0\Field23[$02] = packtwovalues($EC, $104)
    local0\Field24[$02] = 0.33
    local0\Field25[$02] = 45.0
    local0\Field23[$03] = packtwovalues($12D, $13F)
    local0\Field24[$03] = 0.33
    local0\Field25[$03] = 30.0
    local0\Field23[$04] = packtwovalues($165, $17D)
    local0\Field24[$04] = 0.1
    local0\Field23[$05] = packtwovalues($17E, $196)
    local0\Field24[$05] = 0.3
    local0\Field25[$05] = 45.0
    local0\Field23[$06] = packtwovalues($C1, $C5)
    local0\Field24[$06] = 0.025
    local0\Field23[$07] = packtwovalues($C7, $D1)
    local0\Field24[$07] = 0.33
    local0\Field25[$07] = 35.0
    local0\Field23[$08] = packtwovalues($322, $336)
    local0\Field24[$08] = 0.23
    local0\Field23[$09] = packtwovalues($30D, $321)
    local0\Field24[$09] = 0.33
    local0\Field28[$08] = $01
    local0\Field28[$09] = $01
    local0\Field26[$00] = packtwovalues($01, $14)
    local0\Field27[$00] = 0.4
    local0\Field26[$01] = packtwovalues($29, $3C)
    local0\Field27[$01] = 0.4
    local0\Field26[$02] = packtwovalues($2A6, $2C7)
    local0\Field27[$02] = 0.4
    local0\Field26[$03] = packtwovalues($2C8, $30B)
    local0\Field27[$03] = 0.4
    setplayermodelmeshsound($04, $00, "SFX\Character\D9341\BreathGasRelaxed.ogg")
    createplayermodelmesh($02, "GFX\Items\Wearable\Hazmat_wearmodel.b3d", $01)
    createplayermodeltexture($04, "GFX\Items\hazmat_suit.png", $01)
    setplayermodelterminatedtexture($04, "GFX\Items\hazmat_suit_bloody.png")
    createplayermodeltexture(local1, "GFX\Items\hazmat_suit_heavy.png", $01)
    setplayermodelterminatedtexture(local1, "GFX\Items\hazmat_suit_heavy_bloody.png")
    local0 = getplayermodelmeshpreset($02)
    local0\Field7 = $28
    local0\Field10 = -0.3
    local0\Field9 = 180.0
    local0\Field1 = "Bip01_Spine1"
    local0\Field0 = "Bip01_Head"
    local0\Field3 = "Bip01_L_Forearm"
    local0\Field2 = "Bip01_L_Finger0"
    local0\Field8 = $01
    local0\Field6 = $46
    local0\Field4 = $1E
    local0\Field5 = $3C
    local0\Field12 = 0.013
    local0\Field11 = 0.3
    local0\Field14 = 0.0
    local0\Field15 = 70.0
    local0\Field16 = 10.0
    local0\Field17 = -0.03
    local0\Field18 = 0.015
    local0\Field19 = 0.0
    local0\Field20 = -60.0
    local0\Field21 = -45.0
    local0\Field22 = 0.0
    local0\Field23[$01] = packtwovalues($D2, $EB)
    local0\Field24[$01] = 0.1
    local0\Field23[$02] = packtwovalues($EC, $104)
    local0\Field24[$02] = 0.33
    local0\Field25[$02] = 40.0
    local0\Field23[$03] = packtwovalues($12D, $13F)
    local0\Field24[$03] = 0.33
    local0\Field25[$03] = 30.0
    local0\Field23[$04] = packtwovalues($165, $17D)
    local0\Field24[$04] = 0.1
    local0\Field23[$05] = packtwovalues($17E, $196)
    local0\Field24[$05] = 0.3
    local0\Field25[$05] = 40.0
    local0\Field23[$06] = packtwovalues($C1, $C5)
    local0\Field24[$06] = 0.025
    local0\Field23[$07] = packtwovalues($C7, $D1)
    local0\Field24[$07] = 0.33
    local0\Field25[$07] = 35.0
    local0\Field23[$08] = packtwovalues($165, $17D)
    local0\Field24[$08] = 0.25
    local0\Field23[$09] = packtwovalues($17E, $196)
    local0\Field24[$09] = 0.25
    local0\Field26[$00] = packtwovalues($01, $14)
    local0\Field27[$00] = 0.4
    local0\Field26[$01] = packtwovalues($29, $3C)
    local0\Field27[$01] = 0.4
    setplayermodelmeshsound($02, $00, "SFX\Character\D9341\BreathGasRelaxed.ogg")
    createattachmodel($01, "GFX\Items\Wearable\gasmask_wearmodel.b3d", "GFX\Items\gas_mask.png", $01)
    createattachmodel($02, "GFX\Items\Wearable\gasmask_wearmodel.b3d", "GFX\Items\gas_mask.png", $01)
    createattachmodel($03, "GFX\Items\Wearable\gasmask_wearmodel.b3d", "GFX\Items\gas_mask.png", $01)
    createattachmodel($04, "GFX\Items\Wearable\gasmask_wearmodel.b3d", "GFX\Items\gas_mask_heavy.png", $01)
    createattachmodel($05, "GFX\Items\Wearable\Ballistic_vest_wearmodel.b3d", "GFX\Items\ballistic_vest.png", $01)
    createattachmodel($06, "GFX\Items\Wearable\Ballistic_vest_wearmodel.b3d", "GFX\Items\ballistic_vest.png", $01)
    createattachmodel($07, "GFX\Items\ballistic_helmet.b3d", "GFX\Items\ballistic_helmet.png", $01)
    setattachmodelvariety($07, $01, "GFX\Items\Wearable\ballistic_helmet_visor.b3d", "GFX\Items\ballistic_helmet.png")
    setattachmodelvariety($07, $02, "GFX\Items\Wearable\mask.b3d", "GFX\Items\Wearable\mask.png")
    createattachmodel($08, "GFX\Items\Wearable\NVG_wearmodel.b3d", "GFX\Items\night_vision_goggles_green.png", $01)
    createattachmodel($09, "GFX\Items\Wearable\NVG_wearmodel.b3d", "GFX\Items\night_vision_goggles_red.png", $01)
    createattachmodel($0A, "GFX\Items\Wearable\NVG_wearmodel.b3d", "GFX\Items\night_vision_goggles_blue.png", $01)
    createattachmodel($0B, "GFX\Items\Wearable\SCRAMBLE_gear_wearmodel.b3d", "GFX\Items\SCRAMBLE_gear.png", $01)
    createattachmodel($0C, "GFX\Items\Wearable\SCRAMBLE_gear_wearmodel.b3d", "GFX\Items\SCRAMBLE_gear.png", $01)
    createattachmodel($0D, "GFX\Items\Wearable\427_wearmodel.b3d", "GFX\Items\scp_427.png", $01)
    createattachmodel($0F, "GFX\Items\scp_268.b3d", "", $01)
    createattachmodel($10, "GFX\Items\scp_268.b3d", "", $01)
    createattachmodel($0E, "GFX\Items\scp_268.b3d", "", $01)
    createattachmodel($11, "GFX\Items\scp_714.b3d", "", $01)
    createattachmodel($12, "GFX\Items\scp_714.b3d", "GFX\Items\scp_714_grey.png", $01)
    setattachmodelsound($01, $00, "SFX\Character\D9341\BreathGasRelaxed.ogg")
    setattachmodelsound($02, $00, "SFX\Character\D9341\BreathGasRelaxed.ogg")
    setattachmodelsound($03, $00, "SFX\Character\D9341\BreathGasRelaxed.ogg")
    setattachmodelsound($04, $00, "SFX\Character\D9341\BreathGasRelaxed.ogg")
    local2 = createattachmodelpreset($01, $01)
    local2\Field0 = "Bip01_Head"
    local2\Field2 = 179.9
    local2\Field3 = -90.0
    local2\Field4 = -3.0
    local2\Field6 = 0.5
    local2\Field7 = 1.04705
    copyattachmodelpreset($01, $01, $02)
    copyattachmodelpreset($01, $01, $03)
    copyattachmodelpreset($01, $01, $04)
    local2 = createattachmodelpreset($07, $01)
    local2\Field0 = "Bip01_Head"
    local2\Field3 = 90.0
    local2\Field4 = -3.5
    local2\Field7 = 1.04705
    local2 = createattachmodelpreset($08, $01)
    local2\Field0 = "Bip01_Head"
    local2\Field3 = -90.0
    local2\Field4 = -3.5
    local2\Field6 = 4.6
    local2\Field7 = 0.97725
    copyattachmodelpreset($08, $01, $09)
    copyattachmodelpreset($08, $01, $0A)
    copyattachmodelpreset($08, $01, $0B)
    copyattachmodelpreset($08, $01, $0C)
    local2 = createattachmodelpreset($0F, $01)
    local2\Field0 = "Bip01_Head"
    local2\Field3 = 90.0
    local2\Field4 = -5.1
    local2\Field6 = 1.7
    local2\Field7 = 4.88625
    copyattachmodelpreset($0F, $01, $10)
    copyattachmodelpreset($0F, $01, $0E)
    local2 = createattachmodelpreset($0D, $01)
    local2\Field0 = "Bip01_Neck"
    local2\Field4 = 0.3
    local2\Field6 = 3.5
    local2\Field3 = 90.0
    local2\Field2 = -65.0
    local2\Field7 = 1.04705
    local2 = createattachmodelpreset($05, $01)
    local2\Field0 = "Bip01_Spine1"
    local2\Field7 = 1.15176
    local2\Field2 = 179.9
    local2\Field3 = -90.0
    local2\Field4 = -1.5
    copyattachmodelpreset($05, $01, $06)
    local2 = createattachmodelpreset($11, $01)
    local2\Field0 = "Bip01_L_Finger0"
    local2\Field7 = 13.9609
    local2\Field3 = 90.0
    local2\Field4 = -1.0
    local2\Field5 = -1.3
    copyattachmodelpreset($11, $01, $12)
    local2 = createattachmodelpreset($01, $03)
    local2\Field0 = "Bip01_Head"
    local2\Field2 = 179.9
    local2\Field3 = -90.0
    local2\Field4 = -3.0
    local2\Field6 = 0.5
    local2\Field7 = 1.04705
    copyattachmodelpreset($01, $03, $02)
    copyattachmodelpreset($01, $03, $03)
    copyattachmodelpreset($01, $03, $04)
    local2 = createattachmodelpreset($07, $03)
    local2\Field0 = "Bip01_Head"
    local2\Field3 = 90.0
    local2\Field4 = -2.3
    local2\Field6 = 1.0
    local2\Field7 = 0.9
    local2\Field8 = $02
    local2 = createattachmodelpreset($08, $03)
    local2\Field0 = "Bip01_Head"
    local2\Field3 = -90.0
    local2\Field4 = -3.5
    local2\Field6 = 4.6
    local2\Field7 = 0.97725
    copyattachmodelpreset($08, $03, $09)
    copyattachmodelpreset($08, $03, $0A)
    copyattachmodelpreset($08, $03, $0B)
    copyattachmodelpreset($08, $03, $0C)
    local2 = createattachmodelpreset($0F, $03)
    local2\Field0 = "Bip01_Head"
    local2\Field3 = 90.0
    local2\Field4 = -5.1
    local2\Field6 = 1.7
    local2\Field7 = 4.88625
    copyattachmodelpreset($0F, $03, $10)
    copyattachmodelpreset($0F, $03, $0E)
    local2 = createattachmodelpreset($0D, $03)
    local2\Field0 = "Bip01_Neck"
    local2\Field4 = 0.3
    local2\Field6 = 3.5
    local2\Field3 = 90.0
    local2\Field2 = -65.0
    local2\Field7 = 1.04705
    local2 = createattachmodelpreset($05, $03)
    local2\Field0 = "Bip01_Spine1"
    local2\Field7 = 1.15176
    local2\Field2 = 179.9
    local2\Field3 = -90.0
    local2\Field4 = -1.5
    copyattachmodelpreset($05, $03, $06)
    local2 = createattachmodelpreset($11, $03)
    local2\Field0 = "Bip01_L_Finger0"
    local2\Field7 = 13.9609
    local2\Field3 = 90.0
    local2\Field4 = -1.0
    local2\Field5 = -1.3
    copyattachmodelpreset($11, $03, $12)
    local2 = createattachmodelpreset($01, $04)
    local2\Field0 = "Bip01_Head"
    local2\Field2 = 179.9
    local2\Field3 = -90.0
    local2\Field4 = -3.0
    local2\Field6 = 0.5
    local2\Field7 = 1.04705
    copyattachmodelpreset($01, $04, $02)
    copyattachmodelpreset($01, $04, $03)
    copyattachmodelpreset($01, $04, $04)
    local2 = createattachmodelpreset($07, $04)
    local2\Field0 = "Bip01_Head"
    local2\Field3 = 90.0
    local2\Field4 = -2.3
    local2\Field6 = 1.0
    local2\Field7 = 0.9
    local2\Field8 = $02
    local2 = createattachmodelpreset($08, $04)
    local2\Field0 = "Bip01_Head"
    local2\Field3 = -90.0
    local2\Field4 = -3.5
    local2\Field6 = 4.6
    local2\Field7 = 0.97725
    copyattachmodelpreset($08, $04, $09)
    copyattachmodelpreset($08, $04, $0A)
    copyattachmodelpreset($08, $04, $0B)
    copyattachmodelpreset($08, $04, $0C)
    local2 = createattachmodelpreset($0F, $04)
    local2\Field0 = "Bip01_Head"
    local2\Field3 = 90.0
    local2\Field4 = -5.1
    local2\Field6 = 1.7
    local2\Field7 = 4.88625
    copyattachmodelpreset($0F, $04, $10)
    copyattachmodelpreset($0F, $04, $0E)
    local2 = createattachmodelpreset($0D, $04)
    local2\Field0 = "Bip01_Neck"
    local2\Field4 = 0.3
    local2\Field6 = 3.5
    local2\Field3 = 90.0
    local2\Field2 = -65.0
    local2\Field7 = 1.04705
    local2 = createattachmodelpreset($05, $04)
    local2\Field0 = "Bip01_Spine1"
    local2\Field7 = 1.15176
    local2\Field2 = 179.9
    local2\Field3 = -90.0
    local2\Field4 = -1.5
    copyattachmodelpreset($05, $04, $06)
    local2 = createattachmodelpreset($11, $04)
    local2\Field0 = "Bip01_L_Finger0"
    local2\Field7 = 13.9609
    local2\Field3 = 90.0
    local2\Field4 = -1.0
    local2\Field5 = -1.3
    copyattachmodelpreset($11, $04, $12)
    Return $00
End Function
