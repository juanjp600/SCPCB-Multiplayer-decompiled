Function createnpcasset%(arg0.npcs)
    Local local0#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Select arg0\Field4
        Case $14
            arg0\Field1 = copyentity(n_i\Field0[$20], $00)
            local0 = (inigetfloat("Data\NPCs.ini", "Guard", "Scale", 0.0, $01) / 2.5)
            local0 = ((local0 + 1.68) / meshwidth(arg0\Field1))
            scaleentity(arg0\Field1, local0, local0, local0, $00)
            hideentity(arg0\Field1)
        Case $13
            If (arg0\Field1 <> $00) Then
                entityparent(arg0\Field1, $00, $01)
                freeentity(arg0\Field1)
                arg0\Field1 = $00
            EndIf
            local2 = entityyaw(arg0\Field0, $00)
            local3 = entityx(arg0\Field0, $00)
            local4 = entityy(arg0\Field0, $00)
            local5 = entityz(arg0\Field0, $00)
            local6 = animtime(arg0\Field0)
            rotateentity(arg0\Field0, 0.0, 0.0, 0.0, $00)
            positionentity(arg0\Field0, 0.0, 0.0, 0.0, $00)
            setnpcframe(arg0, 1.0, $01)
            If (i_035\Field0 <> 0) Then
                arg0\Field1 = loadmesh_strict("GFX\NPCs\scp_035_sad.b3d", $00)
            Else
                arg0\Field1 = loadmesh_strict("GFX\NPCs\scp_035_smile.b3d", $00)
            EndIf
            local0 = (inigetfloat("Data\NPCs.ini", "Class D", "Scale", 0.0, $01) / meshwidth(arg0\Field0))
            scaleentity(arg0\Field1, local0, local0, local0, $01)
            positionentity(arg0\Field1, 0.0, 0.86, -0.094, $01)
            rotateentity(arg0\Field1, 0.0, entityyaw(arg0\Field0, $01), 0.0, $01)
            entityparent(arg0\Field1, findchild(arg0\Field0, "Bip01_Head"), $01)
            rotateentity(arg0\Field0, 0.0, local2, 0.0, $00)
            positionentity(arg0\Field0, local3, local4, local5, $00)
            setnpcframe(arg0, local6, $01)
    End Select
    arg0\Field63 = $01
    Return $00
End Function
