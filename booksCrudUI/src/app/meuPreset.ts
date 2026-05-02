import { definePreset } from '@primeuix/themes';
import Aura from '@primeuix/themes/aura';
import { colorScheme } from '@primeuix/themes/aura/autocomplete';

export const MeuTema = definePreset(Aura, {
    semantic: {
        colorScheme: {
            light: {
                primary: {
                    50: '#FDEBEC',
                    100: '#F8CFCF',
                    200: '#F1A3A4',
                    300: '#E87778',
                    400: '#D94C4E',
                    500: '#C13234',
                    600: '#A8282A',
                    700: '#8F1F21',
                    800: '#761718',
                    900: '#5C1012',
                    950: '#921A1D'

                },
                surface: {
                    50: '#FDF8F8',
                    100: '#F7F1F1',
                    200: '#EDE3E3',
                    300: '#E0D2D2',
                    400: '#CBB7B7',
                    500: '#A99A9A',
                    600: '#8A7C7C',
                    700: '#6B5E5E',
                    800: '#4D4141',
                    900: '#312626',
                    950: '#1A1212'

                }


            }
        }

    }
});