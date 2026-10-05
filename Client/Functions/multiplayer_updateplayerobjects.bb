Function multiplayer_updateplayerobjects%(arg0.players)
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    If ((entityexist(arg0\Field25[$00]) And (camera <> $00)) <> 0) Then
        If ((((((arg0\Field49 <> model_966) Or multiplayer_isafriend(myplayer\Field49, arg0\Field49)) And (arg0\Field49 <> $00)) And (arg0\Field76 = $01)) And networkserver\Field52\Field11) <> 0) Then
            local0 = ((arg0\Field53 > $04) And (arg0\Field53 < $0B))
            local1 = entityx(arg0\Field13, $01)
            local2 = entityy(arg0\Field13, $01)
            local3 = entityz(arg0\Field13, $01)
            local4 = (0.32 - (0.32 * (Float local0)))
            local5 = arg0\Field90
            positionentity(arg0\Field25[$00], local1, (((0.76 * local5) + local2) - local4), local3, $00)
            If (((arg0\Field49 = myplayer\Field49) Or multiplayer_isafriend(myplayer\Field49, arg0\Field49)) <> 0) Then
                settypecolor(arg0\Field49)
            Else
                setcolorex($FF, $FF, $FF)
            EndIf
            entitycolor(arg0\Field25[$00], (Float colorredex()), (Float colorgreenex()), (Float colorblueex()))
            showentity(arg0\Field25[$00])
            If (networkserver\Field52\Field10 = $01) Then
                If (arg0\Field43 <> 0) Then
                    showentity(arg0\Field25[$02])
                    positionentity(arg0\Field25[$02], local1, ((((0.9 - ((Float (entityexist(arg0\Field25[$03]) = $00)) * 0.06)) * local5) + local2) - local4), local3, $00)
                Else
                    hideentity(arg0\Field25[$02])
                EndIf
            Else
                hideentity(arg0\Field25[$02])
            EndIf
            If (arg0\Field30 <> 0) Then
                showentity(arg0\Field25[$01])
                positionentity(arg0\Field25[$01], local1, (((((1.0 - ((Float (arg0\Field43 = $00)) * 0.1)) - ((Float (entityexist(arg0\Field25[$03]) = $00)) * 0.06)) * local5) + local2) - local4), local3, $00)
                If (arg0\Field26 <> afkspriteframe) Then
                    entitytexture(arg0\Field25[$01], afkspritetexture, afkspriteframe, $00)
                    arg0\Field26 = afkspriteframe
                EndIf
            Else
                hideentity(arg0\Field25[$01])
            EndIf
            If (entityexist(arg0\Field25[$03]) <> 0) Then
                entitycolor(arg0\Field25[$03], (Float arg0\Field87), (Float arg0\Field88), (Float arg0\Field89))
                showentity(arg0\Field25[$03])
                positionentity(arg0\Field25[$03], local1, (((0.84 * local5) + local2) - local4), local3, $00)
            EndIf
        Else
            hideentity(arg0\Field25[$02])
            hideentity(arg0\Field25[$01])
            hideentity(arg0\Field25[$00])
            If (entityexist(arg0\Field25[$03]) <> 0) Then
                hideentity(arg0\Field25[$03])
            EndIf
        EndIf
    EndIf
    multiplayer_updateplayersize(arg0\Field0)
    Return $00
End Function
