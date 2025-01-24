Function loaddoors%()
    Local local0%
    d_i = (New doorinstance)
    d_i\Field0[$00] = loadmesh_strict("GFX\Map\Props\Door01.b3d", $00)
    d_i\Field0[$01] = loadmesh_strict("GFX\Map\Props\ElevatorDoor.b3d", $00)
    d_i\Field0[$02] = loadmesh_strict("GFX\Map\Props\HeavyDoor1.b3d", $00)
    d_i\Field0[$03] = loadmesh_strict("GFX\Map\Props\HeavyDoor2.b3d", $00)
    d_i\Field0[$04] = loadmesh_strict("GFX\Map\Props\contdoorleft.b3d", $00)
    d_i\Field0[$05] = loadmesh_strict("GFX\Map\Props\contdoorright.b3d", $00)
    d_i\Field0[$06] = loadanimmesh_strict("GFX\Map\Props\officedoor.b3d", $00)
    d_i\Field0[$07] = loadmesh_strict("GFX\Map\Props\DoorWooden.b3d", $00)
    d_i\Field0[$08] = loadmesh_strict("GFX\Map\Props\Door02.b3d", $00)
    For local0 = $00 To $08 Step $01
        hideentity(d_i\Field0[local0])
    Next
    d_i\Field1[$00] = loadmesh_strict("GFX\Map\Props\DoorFrame.b3d", $00)
    d_i\Field1[$01] = loadmesh_strict("GFX\Map\Props\ContDoorFrame.b3d", $00)
    d_i\Field1[$02] = loadmesh_strict("GFX\Map\Props\officedoorframe.b3d", $00)
    d_i\Field1[$03] = loadmesh_strict("GFX\Map\Props\DoorWoodenFrame.b3d", $00)
    For local0 = $00 To $03 Step $01
        hideentity(d_i\Field1[local0])
    Next
    d_i\Field5[$01] = loadtexture_strict("GFX\Map\Textures\elevator_panel_down.png", $01, $01, $01)
    d_i\Field5[$00] = loadtexture_strict("GFX\Map\Textures\elevator_panel_up.png", $01, $01, $01)
    d_i\Field5[$02] = loadtexture_strict("GFX\Map\Textures\elevator_panel_idle.png", $01, $01, $01)
    d_i\Field4 = loadmesh_strict("GFX\Map\Props\elevator_panel.b3d", $00)
    hideentity(d_i\Field4)
    d_i\Field3[$00] = loadtexture_strict("GFX\Map\Textures\keypad.jpg", $01, $01, $01)
    d_i\Field3[$01] = loadtexture_strict("GFX\Map\Textures\keypad_using.png", $01, $01, $01)
    d_i\Field3[$02] = loadtexture_strict("GFX\Map\Textures\keypad_locked.png", $01, $01, $01)
    d_i\Field3[$03] = loadtexture_strict("GFX\Map\Textures\keypad_106.png", $01, $01, $01)
    d_i\Field2[$00] = loadanimmesh_strict("GFX\Map\Props\Button.b3d", $00)
    d_i\Field2[$01] = loadmesh_strict("GFX\Map\Props\ButtonKeycard.b3d", $00)
    d_i\Field2[$02] = loadmesh_strict("GFX\Map\Props\ButtonCode.b3d", $00)
    d_i\Field2[$03] = loadmesh_strict("GFX\Map\Props\ButtonScanner.b3d", $00)
    d_i\Field2[$04] = loadanimmesh_strict("GFX\Map\Props\ButtonElevator.b3d", $00)
    For local0 = $00 To $04 Step $01
        hideentity(d_i\Field2[local0])
    Next
    Return $00
End Function
