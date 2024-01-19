Function plugin_poke%(arg0%, arg1$, arg2%)
    Local local0.plugin
    Local local2%
    Local local3%
    local0 = plugins[arg0]
    If (local0 <> Null) Then
        Select arg2
            Case $01
                resizebank(local0\Field2, (banksize(local0\Field2) + $01))
                pokebyte(local0\Field2, (banksize(local0\Field2) - $01), (Int arg1))
            Case $02
                resizebank(local0\Field2, (banksize(local0\Field2) + $02))
                pokeshort(local0\Field2, (banksize(local0\Field2) - $02), (Int arg1))
            Case $03
                resizebank(local0\Field2, (banksize(local0\Field2) + $04))
                pokeint(local0\Field2, (banksize(local0\Field2) - $04), (Int arg1))
            Case $04
                resizebank(local0\Field2, (banksize(local0\Field2) + $04))
                pokefloat(local0\Field2, (banksize(local0\Field2) - $04), (Float arg1))
            Case $05
                local2 = banksize(local0\Field2)
                resizebank(local0\Field2, (banksize(local0\Field2) + len(arg1)))
                For local3 = $01 To len(arg1) Step $01
                    pokebyte(local0\Field2, ((local2 + local3) - $01), asc(mid(arg1, local3, $01)))
                Next
            Default
                Return $00
        End Select
        Return $01
    EndIf
    Return $00
    Return $00
End Function
