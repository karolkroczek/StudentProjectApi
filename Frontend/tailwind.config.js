/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    colors:{
      basicRed:{
        default:"#B00B3B"
      },
      basicRedDarker:{
        default:"#8B092E"
      },
      backgroundBlack:{
        default:"#2A2835"
      },
      backgroundGray:{
        default:"#D9D9D9"
      },
      white:{
        default:"#FFFFFF"
      },
      black:{
        default:"#000000"
      },
    },
    extend: {
      keyframes:{
        slideLeft:{
          '0%':{
            transform:'translateX(50px)',
            opacity:'0.25'
              
        },
          '100%':{
            transform:'translateX(0px)',
            opacity:'1'
          },
        },
        slideDown:{
          '0%':{
            transform:'translateY(-50px)',
            opacity:'0'
              
        },
          '100%':{
            transform:'translateY(0px)',
            opacity:'1'
          },
        }
      },
      animation:{
        'slide-left':'slideLeft 0.5s ease-out',
        'slide-down':'slideDown 0.5s ease-out'
      }
    },
  },
  plugins: [],
}