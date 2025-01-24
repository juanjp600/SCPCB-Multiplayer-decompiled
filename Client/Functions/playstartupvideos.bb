Function playstartupvideos%()
    Local local0%
    Local local1$
    For local0 = $00 To $03 Step $01
        Select local0
            Case $00
                local1 = "startup_Undertow"
            Case $01
                local1 = "startup_TSS"
            Case $02
                local1 = "startup_UET"
            Case $03
                local1 = "startup_Warning"
        End Select
        playmovie(local1)
    Next
    Return $00
End Function
